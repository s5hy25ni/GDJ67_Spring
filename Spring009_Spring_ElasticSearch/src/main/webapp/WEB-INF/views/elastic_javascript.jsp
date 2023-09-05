<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바스크립트로 엘라스틱서치하기</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
  $("#searchButton").click(searchTeacher);
});

async function searchTeacher() {
  try {
    const elasticUrl = "http://192.168.8.164:9200";
    const indexName = "teacher";
    
    
    
    const subject = $("#subject").val();
    const nickname = $("#nickname").val();
    
    // 필터 조건에 맞춰서 쿼리를 조합한다
    let filter = { bool: {} };
    if (subject && !nickname) {
      filter.bool = {
        must: {
          multi_match: {
            query: subject,
            fields: ["subject", "introduction"]
          }
        }
      };
    } else if (!subject && nickname) {
      const query = {
    	wildcard: {
    	    nickname: {
    	       value: "*" + nickname + "*"
    	     }
    	}
      };
      filter.bool = {
        must: query
      };
    } else if (subject && nickname) {
      const subjectQuery = {
        multi_match: {
          query: subject,
          fields: ["subject", "introduction"]
        }
      };
      
      const nicknameQuery = {
    	wildcard: {
    	   nickname: {
    	    value: "*" + nickname + "*"
    	    }
    	  }
      };
      filter.bool = {
        must: [subjectQuery, nicknameQuery]
      }
    }
    
    const requestBody = {
      query: {
        bool: filter.bool
      },
      size: 300, // 결과를 최대 300개까지 출력
      from: 0
    };
    
    const requestOptions = {
  	      method: "POST",
  	      body: JSON.stringify(requestBody),
  	      headers: {
  	        "Content-Type": "application/json",
  	      	'Authorization': 'Basic ' + btoa('elastic:elastic')
  	      },
  	    };
    
    const response = await fetch(elasticUrl+"/"+indexName+"/_search", requestOptions);
    console.log(response);

    if (response.ok) {
      const jsonResponse = await response.json();
      const hits = jsonResponse.hits.hits;
      const results = hits.map((hit) => hit._source);
      console.log(results);
      $("#resultDiv").empty(); // 이전 검색 결과를 지운다
      results.forEach((result) => {
        const name = result.nickname;
        const introduction = result.introduction;
        const subject = result.subject;
        const age = result.age;
        const resultString = "<p>강사 이름: " + name + " | 소개: " + introduction + " | 과목: " + subject + "| 나이: "+ age +"</p>";
        $("#resultDiv").append(resultString);
      });
    } else {
      console.error("Request failed:", response.status, response.statusText);
    }
  } catch (error) {
    console.error("에러:", error);
  }
}
</script>
</head>
<body>

	<input type="text" placeholder="과목" id="subject">
	<br>
	<input type="text" placeholder="이름" id="nickname">
	<br>
	<input type="button" value="검색" id="searchButton">
	<div id="resultDiv"></div>

</body>
</html>