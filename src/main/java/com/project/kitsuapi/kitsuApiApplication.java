package com.project.kitsuapi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.project.kitsuapi.config.AppConfiguration;
import com.project.kitsuapi.config.SwaggerConfiguration;

@SpringBootApplication
public class kitsuApiApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(
       		kitsuApiApplication.class,
            AppConfiguration.class,
            SwaggerConfiguration.class
        ).run();
    }

}
