package com.sparta.week03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //수정발생시 자동으로 업데이트
public class Week03Application {

	public static void main(String[] args) {
		SpringApplication.run(Week03Application.class, args);
	}

}
