package com.itheima.medicinesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itheima.medicinesystem.mapper")
public class MedicineSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(MedicineSystemApplication.class, args);
    }
}