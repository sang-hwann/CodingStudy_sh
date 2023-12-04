package com.example.week04.utils;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class NaverShopSearch {

    public String search(){
        RestTemplate rest = new RestTemplate(); //스프링에서는 RestTemplate를 이용함
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "2GX4crCT9jjbdIhidYDO");
        headers.add("X-Naver-Client-Secret", "H4LotiD8sG");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=아디다스", HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = (HttpStatus) responseEntity.getStatusCode(); //(HttpStatus)로 강제변환함 , 원래는 없음
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;
    }

    public static void main(String[] args) {
        NaverShopSearch naverShopSearch = new NaverShopSearch();
        naverShopSearch.search();
    }
}
