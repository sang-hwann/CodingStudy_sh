package com.example.week04.utils;

import com.example.week04.models.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class NaverShopSearch {

    public String search(String query) {
        RestTemplate rest = new RestTemplate(); //스프링에서는 RestTemplate를 이용함
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "2GX4crCT9jjbdIhidYDO");
        headers.add("X-Naver-Client-Secret", "H4LotiD8sG");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query="+query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = (HttpStatus) responseEntity.getStatusCode(); //(HttpStatus)로 강제변환함 , 원래는 없음
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        //System.out.println("Response status: " + status);
        //System.out.println(response);

        return response;
    }

    // 메소드로 구성해서 사용할수 있도록 구성
    public List<ItemDto> fromJSONtoItems(String result){
        JSONObject rjson = new JSONObject(result); //result 문자열을 이야기한다. result이란 문자열을 JSONObject로 구성한다.
        JSONArray items = rjson.getJSONArray("items"); //검색한 rjson에서 items의 Json배열을 꺼내겠다는 의미

        List<ItemDto> itemDtoList = new ArrayList<>();

        for (int i = 0; i < items.length(); i++) {
            JSONObject itemJson = items.getJSONObject(i);
//            System.out.println(itemJson); //밑의 방식으로 각 키값으로 값을 가져와 출력할수도 있다.
//            String title = itemJson.getString("title");
//            String image = itemJson.getString("image");
//            int lprice = itemJson.getInt("lprice");
//            String link= itemJson.getString("link");
//            System.out.println(lprice);

            ItemDto itemDto = new ItemDto(itemJson); // 그런식으로 JsonObject를 Dto에 값을 입력

            itemDtoList.add(itemDto); // 받은 json값을 리스트에 추가
        }
        return itemDtoList;
    }

    //위의 메소드내용이 들어갔었는데 필요없어서 삭제함
//    public static void main(String[] args) {
//        NaverShopSearch naverShopSearch = new NaverShopSearch();
//        String result = naverShopSearch.search("아이맥");
//
//    }
}
