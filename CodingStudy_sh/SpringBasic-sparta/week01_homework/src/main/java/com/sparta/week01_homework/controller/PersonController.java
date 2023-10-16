package com.sparta.week01_homework.controller;

import com.sparta.week01_homework.models.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @GetMapping("/myinfo")
    public Person getPersonInfo() {
    Person person = new Person();
    person.setName("손흥민");
    person.setAddress("런던");
    person.setAge(28);
    person.setJob("대한민국 축구선수");

    return person;
    }
}
