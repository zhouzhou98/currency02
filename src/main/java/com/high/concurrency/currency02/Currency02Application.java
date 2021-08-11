package com.high.concurrency.currency02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.high.concurrency.currency02.mapper")
public class Currency02Application {

    public static void main(String[] args) {
        SpringApplication.run(Currency02Application.class, args);
    }

}
