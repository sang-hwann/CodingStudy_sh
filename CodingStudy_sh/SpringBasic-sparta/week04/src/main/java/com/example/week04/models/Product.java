package com.example.week04.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter//get함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor //기본생성자를 만들어줍니다.
@Entity //DB 테이블 역할을 합니다.
public class Product extends Timestamped {
    //ID가 자동으로 생성, 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    //반드시 값을 가지도록합니다.
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int lprice;

    @Column(nullable = false)
    private int myprice;
}
