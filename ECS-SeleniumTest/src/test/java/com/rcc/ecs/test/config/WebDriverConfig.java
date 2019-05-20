package com.rcc.ecs.test.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = WebDriverConfig.PREFIX)
@Data
public class WebDriverConfig {
    public static final String PREFIX = "selenium";
    private String chromePath;
    private String browserName;
    private String firefoxPath;
    //截屏存放路径
    private String screenImagePath;
}
