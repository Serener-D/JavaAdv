package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.PostConstruct;


@Slf4j
@EnableEurekaClient
@SpringBootApplication
public class ConfigClient {

    @Value("${test.word}")
    private String testWord;

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient.class, args);
    }

    @PostConstruct
    private void init() {
        log.info("testWord = {}", testWord);
    }
}