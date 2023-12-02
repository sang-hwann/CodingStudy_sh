package com.example.week04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Week04Application {
    //여기 부터는 spring 3.xx 이용, 2버전은 지원중단함
    //그리고 java도 17부터만 지원해서 17로 바꿈 (8은 지원안해줌)
    public static void main(String[] args) {
        SpringApplication.run(Week04Application.class, args);
    }

}
