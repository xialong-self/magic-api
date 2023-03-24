package com.xialong.magicapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author 夏龙
 * @description 功能描述
 * @create 2023/3/20 18:10
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
//        builder.application().setAdditionalProfiles("local");
        builder.run(args);
    }
}

