package com.learning.springboot.api.configuration;

import com.learning.springboot.api.database.Database;
import com.learning.springboot.api.database.Local;
import com.learning.springboot.api.database.Production;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name = "spring.app.mode", havingValue = "local")
    public Database getLocalDatabase() { return new Local(); }

    @Bean
    @ConditionalOnProperty(name = "spring.app.mode", havingValue = "production")
    public Database getProductionDatabase() { return new Production(); }

    @Bean
    public ModelMapper getModelMapper() { return new ModelMapper(); }
}
