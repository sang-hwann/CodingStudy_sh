package com.example.week04.models;

import lombok.Getter;

@Getter//각각을 꺼내서 쓸수있도록 사용
public class ProductRequestDto {
    private String title;
    private String link;
    private String image;
    private int lprice;
}
