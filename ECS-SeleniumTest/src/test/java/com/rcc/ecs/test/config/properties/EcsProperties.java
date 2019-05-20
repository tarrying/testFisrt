package com.rcc.ecs.test.config.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "ecs")
@Data
public class EcsProperties {
    private String host;
    private String login;
}
