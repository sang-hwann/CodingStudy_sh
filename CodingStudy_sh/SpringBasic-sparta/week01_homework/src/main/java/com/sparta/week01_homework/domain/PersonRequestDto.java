package com.sparta.week01_homework.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@RequiredArgsConstructor
public class PersonRequestDto {
    private final String name;
    private final String address;
    private final int age;
    private final String job;
}
