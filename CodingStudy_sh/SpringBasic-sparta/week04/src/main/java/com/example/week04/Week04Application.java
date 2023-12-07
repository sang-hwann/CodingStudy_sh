package com.example.week04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing//시간 자동변경이 가능하도록함
@SpringBootApplication //스프링 부트임을 선언
public class Week04Application {
    //여기 부터는 spring 3.xx 이용, 2버전은 지원중단함
    //그리고 java도 17부터만 지원해서 17로 바꿈 (8은 지원안해줌)
    public static void main(String[] args) {
        SpringApplication.run(Week04Application.class, args);
    }

}
