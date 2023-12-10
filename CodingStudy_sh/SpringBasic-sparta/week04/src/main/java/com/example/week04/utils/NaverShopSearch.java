package com.example.week04.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class NaverShopSearch {

    public String search(String query) {
        RestTemplate rest = new RestTemplate(); //스프링에서는 RestTemplate를 이용함
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "2GX4crCT9jjbdIhidYDO");
        headers.add("X-Naver-Client-Secret", "H4LotiD8sG");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = (HttpStatus) responseEntity.getStatusCode(); //(HttpStatus)로 강제변환함 , 원래는 없음
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;
    }

    public static void main(String[] args) {
        NaverShopSearch naverShopSearch = new NaverShopSearch();
        String result = naverShopSearch.search("아이맥");
        JSONObject rjson = new JSONObject(result); //result 문자열을 이야기한다. result이란 문자열을 JSONObject로 구성한다.
        JSONArray items = rjson.getJSONArray("items"); //검색한 rjson에서 items의 Json배열을 꺼내겠다는 의미
        for (int i = 0; i < items.length(); i++) {
            JSONObject itemJson = items.getJSONObject(i);
            System.out.println(itemJson);
        }
    }
}
