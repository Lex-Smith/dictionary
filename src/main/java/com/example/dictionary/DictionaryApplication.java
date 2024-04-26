package com.example.dictionary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableCaching
public class DictionaryApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DictionaryApplication.class, args);
    }
}
