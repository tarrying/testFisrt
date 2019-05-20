package com.rcc.ecs.test.config.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *  客户管理列表页面
 */
@Component
@Configuration
@ConfigurationProperties
@PropertySource("classpath:elements/customerlistele.yml")
@Getter
@Setter
public class CustomerListEleProperties {
    private String inputGroup;
    private String searchInput;
    private String searchButton;
    private String dropDownMenu;
    private String dropDownLi;
    private String custTable;
    private String quitEditBtn;
    private String sureBtn;
}
