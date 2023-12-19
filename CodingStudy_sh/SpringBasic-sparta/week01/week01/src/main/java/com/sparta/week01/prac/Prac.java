package com.sparta.week01.prac;

import java.util.ArrayList;
import java.util.List;

public class Prac {

    public static void main(String[] args) {
        String title = "웹개발의 봄, Spring";
        String tutor = "남병관";
        int days = 35;
        Course course = new Course();
        course.setTitle(title);
        course.setTutor(tutor);
        course.setDays(days);
        //course.title = title; 이렇게는 Course에서 변수들이 Public으로 선언되서 그럼
        System.out.println(course.getTitle());
        System.out.println(course.getTutor());
        //test

    }
}
