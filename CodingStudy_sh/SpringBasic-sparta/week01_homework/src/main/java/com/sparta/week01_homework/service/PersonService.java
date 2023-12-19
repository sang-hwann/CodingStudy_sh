package com.sparta.week01_homework.service;

import com.sparta.week01_homework.domain.PersonRepository;
import com.sparta.week01_homework.domain.PersonRequestDto;
import com.sparta.week01_homework.models.Person;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Transactional
    public Long update(Long id, PersonRequestDto requestDto) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("없는 아이디입니다."));
        person.update(requestDto);
        return person.getId();
    }
}
