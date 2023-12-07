package com.example.week04.controller;

import com.example.week04.models.Product;
import com.example.week04.models.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor //final로 선언된 멤버 변수를 자동으로 생성
@RestController //json으로 데이터를 주고받음을 선언
public class ProductRestController {
    //final은 꼭필요하다는것을 의미
    private final ProductRepository productRepository; //레보지토리 선언 , 원할때마다 자동으로 생성

    //동록된 전체상품 목록조회
    @GetMapping("/api/products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
}
