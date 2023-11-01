package com.sparta.week01_homework.controller;

import com.sparta.week01_homework.domain.PersonRepository;
import com.sparta.week01_homework.domain.PersonRequestDto;
import com.sparta.week01_homework.models.Person;
import com.sparta.week01_homework.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;
    private final PersonService personService;

    @GetMapping("/myinfo")
    public Person getPersonInfo() {
        Person person = new Person();
        person.setName("손흥민");
        person.setAddress("런던");
        person.setAge(28);
        person.setJob("대한민국 축구선수");

        return person;
    }

    @PostMapping("/api/persons")
    public Person createPerson(@RequestBody PersonRequestDto requestDto) {
        Person person = new Person(requestDto);
        return personRepository.save(person);
    }

    @GetMapping("/api/persons")
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @PutMapping("/api/persons/{id}")
    public Long updatePersons(@PathVariable Long id, @RequestBody PersonRequestDto requestDto) {
        return personService.update(id, requestDto);
    }

    @DeleteMapping("/api/persons/{id}")
    public Long deletePersons(@PathVariable Long id) {
        personRepository.deleteById(id);
        return id;
    }


}
