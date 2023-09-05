package com.min.edu;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchPhrasePrefixQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class ElasticController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @PostMapping(value = "/search.do", produces = "application/json;charset=UTF-8")
    public String search(Model model, @RequestBody Map<String, Object> formData)throws IOException {
    	  
    	  List<String> subjects = (List<String>) formData.get("subject");
    	  String gender = (String) formData.get("gender");
    	  List<String> available_locations = (List<String>) formData.get("available_location");
    	  String nickname = (String) formData.get("nickname");
    	  Map<String, Object> ageMap = (Map<String, Object>)formData.get("age");
    	  Integer ageGt = ageMap.get("gt") == null || ageMap.get("gt").toString().isEmpty() ? null : Integer.valueOf(ageMap.get("gt").toString());
    	  Integer ageLt = ageMap.get("lt") == null || ageMap.get("lt").toString().isEmpty() ? null : Integer.valueOf(ageMap.get("lt").toString());
    	  
    	logger.info("@@@@@@@@@@@@@@@@@@전달받은값 subject:{}, gender {}, available_locations {}, nickname {}", subjects, gender, available_locations, nickname);
   	// 검색 쿼리 조합
       BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
       
    // 과목명 조건
       if (subjects != null) {
           Set<String> subjectsSet = new HashSet<>(subjects);
           subjectsSet.remove(""); // 중복 및 빈 문자열 제거
           subjectsSet.remove(null); // 중복 및 null값 제거
           if (!subjectsSet.isEmpty()) {
               BoolQueryBuilder boolSubjectQueryBuilder = QueryBuilders.boolQuery();
               for (String subject : subjectsSet) {
            	   MultiMatchQueryBuilder multiMatchQueryStringBuilder = QueryBuilders.multiMatchQuery(subject)
                           .field("subject").field("introduction");
            	   boolSubjectQueryBuilder.should(multiMatchQueryStringBuilder);
               }
               boolQueryBuilder.filter(boolSubjectQueryBuilder);
           }
       }
       
       // 강사 이름 조건
       if (nickname != null && !nickname.equals("")) {
    	   MatchPhrasePrefixQueryBuilder matchQueryBuilder = QueryBuilders.matchPhrasePrefixQuery("nickname", nickname).maxExpansions(200);
    	   boolQueryBuilder.filter(matchQueryBuilder);
       }
       
       // 나이 조건
       RangeQueryBuilder ageRangeQueryBuilder = QueryBuilders.rangeQuery("age");
       //최소나이
       if (ageGt != null) {
    	    ageRangeQueryBuilder.gte(ageGt);
    	}
    
       //최대나이
    	if (ageLt != null) {
    	    ageRangeQueryBuilder.lte(ageLt);
    	}
       boolQueryBuilder.filter(ageRangeQueryBuilder);

       // 성별 조건
       if (gender != null && !gender.equals("전체")) {
           TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("gender", gender);
           boolQueryBuilder.filter(termQueryBuilder);
       }

       // 지역 조건
       if (available_locations != null) {
           Set<String> locationsSet = new HashSet<>(available_locations);
           locationsSet.remove(""); // 중복 및 빈 문자열 제거
           locationsSet.remove(null); // 중복 및 null값 제거
           if (!locationsSet.isEmpty()) {
               BoolQueryBuilder boolLocationQueryBuilder = QueryBuilders.boolQuery();
               for (String location : locationsSet) {
                   TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("available_location", location).boost(2.0f);
                   boolLocationQueryBuilder.should(termQueryBuilder);
               }
               boolQueryBuilder.filter(boolLocationQueryBuilder);
           }
       }

       
       
       // 검색 쿼리 실행
       SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
       searchSourceBuilder.query(boolQueryBuilder);
       // 검색 결과 수 최대 300개(기본 10개로 설정되어있음)
       searchSourceBuilder.size(300); 
       
       SearchRequest searchRequest = new SearchRequest("teacher");
       searchRequest.source(searchSourceBuilder);

       
       SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
       SearchHits hits = searchResponse.getHits();
       
       // 검색 결과를 Map으로 변환
       List<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();
       for(SearchHit hit : hits.getHits()) {
           Map<String, Object> resultMap = hit.getSourceAsMap();
           resultList.add(resultMap);
       }
       
       // 검색 결과를 view에 전달
       model.addAttribute("resultList", resultList);
       
       Gson gson = new Gson(); // 추가
       
       return gson.toJson(resultList);
   }
}

