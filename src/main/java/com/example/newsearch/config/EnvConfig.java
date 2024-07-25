package com.example.newsearch.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {

    private final Dotenv dotenv = Dotenv.load();

    @Bean
    public String naverClientId() {
        return dotenv.get("NAVER_CLIENT_ID");
    }

    @Bean
    public String naverClientSecret() {
        return dotenv.get("NAVER_CLIENT_SECRET");
    }
}
