package com.sparta.week01_homework.domain;

import com.sparta.week01_homework.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
