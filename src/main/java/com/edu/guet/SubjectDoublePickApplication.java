package com.edu.guet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.edu.guet.dao")
public class SubjectDoublePickApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubjectDoublePickApplication.class, args);
    }

}
