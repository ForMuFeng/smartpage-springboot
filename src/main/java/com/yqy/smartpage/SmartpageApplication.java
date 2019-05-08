package com.yqy.smartpage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yqy.smartpage.Mapper")
public class SmartpageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartpageApplication.class, args);
    }

}
