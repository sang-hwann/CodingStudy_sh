package com.sparta.week02;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing //이 어노테이션으로 수정일자가 저장이됨
@SpringBootApplication
public class Week02Application {

    public static void main(String[] args) {
        SpringApplication.run(Week02Application.class, args);
    }

    // Week02Application.java 의 main 함수 아래에 붙여주세요.
    @Bean
    public CommandLineRunner demo(CourseRepository repository) {
        return (args) -> {
            //데이터 저장
            repository.save(new Course("프론트 엔드의 꽃", "홍길동"));
            //모든 정보 조회후 리스트로 저장
            List<Course> courseList = repository.findAll();
            for (Course course : courseList) {
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }
            //데이터를 한개 조회 ,그리고 예외처리
            //Course course = repository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다."));

            //1L이라는 아이디값을 지정해서 조회하지만 orElseThrow는 혹시모를 예외로 하는것이다.
            Course course1 = repository.findById(1L).orElseThrow(() -> new NullPointerException("아이디가 존재하지 않습니다."));
            // NullPointerException는 가리키는 것이 없을 경우의 예외처리
        };
    }
}
