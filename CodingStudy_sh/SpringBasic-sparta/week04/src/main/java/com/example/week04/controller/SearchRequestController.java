package com.example.week04.controller;


import com.example.week04.models.ItemDto;
import com.example.week04.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor //final로 선언된 클래스를 자동으로 생성 ,이런기능도 component가 선언되서 사용이가능한것이다.
@RestController //JSON으로 읍답함을 선언하기위해 선언
public class SearchRequestController {
    private final NaverShopSearch naverShopSearch;

    @GetMapping("/api/search")
    public List<ItemDto> execSearch(@RequestParam("query") String query) {
        String result = naverShopSearch.search(query);
        return naverShopSearch.fromJSONtoItems(result); //검색 문자로 검색
    }
}