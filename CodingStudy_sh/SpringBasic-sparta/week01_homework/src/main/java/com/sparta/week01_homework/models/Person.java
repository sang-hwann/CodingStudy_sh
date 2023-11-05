package com.sparta.week01_homework.models;

import com.sparta.week01_homework.domain.PersonRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //직역해서 전략은 Auto라는 의미로 자동적으로 증가하도록 만든다는 의미이다.
    private Long id;

    @Column(nullable = false) //꼭 잇어야한다는 의미임 , 컬럼지정
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String job;

    public Person(PersonRequestDto requestDto){
        this.name = requestDto.getName();
        this.address = requestDto.getAddress();
        this.age = requestDto.getAge();
        this.job = requestDto.getJob();
    }

    public void update(PersonRequestDto requestDto){
        this.name = requestDto.getName();
        this.address = requestDto.getAddress();
        this.age = requestDto.getAge();
        this.job = requestDto.getJob();
    }


}
