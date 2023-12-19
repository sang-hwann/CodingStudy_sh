package com.sparta.week02.controller;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import com.sparta.week02.domain.CourseRequestDto;
import com.sparta.week02.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CourseController {
    private final CourseRepository courseRepository;
    private final CourseService courseService;

    //PostMapping을 통해서 , 같은 주소라도 방식이 다름을 구분합니다.
    @PostMapping("/api/courses")
    public Course createCourse(@RequestBody CourseRequestDto requestDto) {
        //requestDto는 생성 요청을 의미합니다.
        //강의 정보를 만들기 위해서는 강의 제목과 튜터의 이름이 필요 , 그정보는 가져오는 것

        //저장하는 것은 Dto가 아니라 Course이니 , Dto정보를 course에 담아야함
        //새로운 생성자 만듬
        Course course = new Course(requestDto);
        return courseRepository.save(course);

    }

    @GetMapping("/api/courses")
    public List<Course> getCourse() {
        return courseRepository.findAll();
    }
    @PutMapping("/api/courses/{id}")
    public Long updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto requestDto) {
        return courseService.update(id, requestDto);
    }

    @DeleteMapping("/api/courses/{id}")
    public Long deleteCourse(@PathVariable Long id){
        courseRepository.deleteById(id);
        return id;
    }
}
