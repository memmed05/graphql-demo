package com.azdev.graphql.config;

import graphql.scalars.ExtendedScalars;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphqlConfig {

    @Bean
    RuntimeWiringConfigurer configurer(){
        return builder -> builder.scalar(ExtendedScalars.DateTime);
    }
}
