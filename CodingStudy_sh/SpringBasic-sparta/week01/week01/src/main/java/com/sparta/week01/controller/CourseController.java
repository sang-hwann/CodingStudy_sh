package com.sparta.week01.controller;

import com.sparta.week01.prac.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //스프링에 JSON으로 응답하는 자동응답기라는 의미를 부여
public class CourseController {

        @GetMapping("/courses")
        public Course getCourses() {
            Course course = new Course();
            course.setTitle("웹개발의 봄 스프링");
            course.setDays(35);
            course.setTutor("남병관");
            return course;
        }
}
