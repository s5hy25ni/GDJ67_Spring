<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>엘라스틱 서치해보기</title>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript">
function searchElastic(query, callback) {
  $.ajax({
    url: 'http://192.168.8.164:9200/subjects/_search',
    type: 'POST',
    dataType: 'json',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa('elastic:elastic')
    },
    data: JSON.stringify({
      suggest: {
        "title-suggestion": {
          "prefix": query,
          "completion": {
            "field": "auto_complete"
          }
        }
      }
    }),
    success: function(response) {
      var results = response.suggest['title-suggestion'][0].options.map(function(option) { 
        return {
          label: option._source.ko_title,
          value: option._source.en_title
        };
      });

      callback(results);
    },
    error: function() {
      callback([]);
    }
  });
}

$(function() {
  $("#subject1, #subject2, #subject3").autocomplete({
    minLength: 1,
    source: function(request, response) {
      searchElastic(request.term, function(results) {
        response(results);
      });
    },
    focus: function() {
      return false;
    },
    select: function(event, ui) {
      this.value = ui.item.label;
      return false;
    }
  });
});

$(document).ready(function () {
    $('form').on('submit', function (event) {
        event.preventDefault();

        var formDataArray = $("#searchForm").serializeArray();
        var formData = {};

        formDataArray.forEach(function (item) {
            if (item.name === 'available_location' || item.name === 'subject') {
                formData[item.name] = formData[item.name] || [];
                formData[item.name].push(item.value);
            } else if(item.name === 'ageLt' || item.name === 'ageGt'){
            	formData['age'] = formData['age'] || {};
                formData['age'][item.name === 'ageLt' ? 'lt' : 'gt'] = item.value;
            } else if (item.value) {
                formData[item.name] = item.value;
            }
        });
        
        console.log("보내는 값: ",JSON.stringify(formData));

        $.ajax({
        	url: "./search.do",
            method: "post",
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function (response) {
            	  var $results = $("#searchResults");
            	    $results.empty(); // 이전 검색 결과를 지움

            	    if (response.length === 0) {
            	        $results.append("<p>검색 조건에 해당하는 강사를 찾을 수 없습니다.</p>");
            	    } else {
            	        response.forEach(function(teacher) {
            	        	var introduction = teacher["introduction"];
            	            var name = teacher["nickname"];
            	            var location = teacher["available_location"];
            	            var subject = teacher["subject"];
            	            var age = teacher["age"];
            	            $results.append("<p>강사 이름: " + name + " | 소개: " + introduction + " | 과목: " + subject + "| 나이: "+ age +"</p>");
            	        });
            	    }
            },
            error: function(){
            	alert("오류");
            }
        });
	});
});	
</script>
</head>
<body>
		<form id="searchForm">
		    <label for="subject"> 과목명:</label>
		    <input type="text" id="subject1" name="subject">
		    <input type="text" id="subject2" name="subject">
		    <input type="text" id="subject3" name="subject"><br>
		    <label for="available_location"> 지역:</label>
		    <input type="text" id="available_location1" name="available_location">
		    <input type="text" id="available_location2" name="available_location">
		    <input type="text" id="available_location3" name="available_location"><br>
		    <label for="gender"> 성별:</label>
		    <input type="radio" id="gender" name="gender" value="남">남
		    <input type="radio" id="gender" name="gender" value="여">여
		    <input type="radio" id="gender" name="gender" value="전체" checked>전체<br>
		    <label for="nickname"> 이름:</label>
		    <input type="text" id="nickname" name="nickname"><br>
		    <label for="age"> 나이:</label>
		    최소<input type="number" id="ageGt" name="ageGt">
		    최대<input type="number" id="ageLt" name="ageLt">
		    <input type="submit" value="검색">
		</form>
 <hr>
 <div id="searchResults">
 </div>
</body> 
</html>