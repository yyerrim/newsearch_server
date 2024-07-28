package com.example.newsearch.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {

//    private final Dotenv dotenv = Dotenv.load();

    private final Dotenv dotenv = Dotenv.configure()
            .directory("/home/ec2-user/newsearch_server") // 명시적으로 디렉터리 지정
            .load();

    @Bean
    public String naverClientId() {
        return dotenv.get("NAVER_CLIENT_ID");
    }

    @Bean
    public String naverClientSecret() {
        return dotenv.get("NAVER_CLIENT_SECRET");
    }
}
