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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false) //꼭잇어야함
    private String name;
    @Column(nullable = false) //꼭잇어야함
    private String address;
    private int age;
    private String job;

    //getter
    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public int getAge() {
        return this.age;
    }

    public String getJob() {
        return this.job;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJob(String job) {
        this.job = job;
    }

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
