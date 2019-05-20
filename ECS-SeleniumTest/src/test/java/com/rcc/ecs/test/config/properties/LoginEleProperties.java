package com.rcc.ecs.test.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties
@PropertySource("classpath:elements/loginele.yml")
@Data
public class LoginEleProperties {

    private String loginBtn;
    private String emailInput;
    private String nextBtn;
    private String passwdInput;
    private String checkBox;

}
