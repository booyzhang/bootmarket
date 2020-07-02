package com.booy.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = "com.booy.boot.dao")
public class MarketerStarter {
    public static void main(String[] args) {
        SpringApplication.run(MarketerStarter.class,args);
    }
}
