package com.learning.springboot.api.configuration;

import com.learning.springboot.api.database.Database;
import com.learning.springboot.api.database.Local;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Database getDatabase() {
        return new Local();
    }
}
