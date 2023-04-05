package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baizhi.mapper")
public class BzYingxiaoApplication {
    public static void main(String[] args) {

        System.out.println("11111111111111111111");
        SpringApplication.run(BzYingxiaoApplication.class, args);
    }
}
