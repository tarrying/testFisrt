package com.rcc.ecs.test.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *  客户新增页面
 */
@Component
@Configuration
@ConfigurationProperties
@PropertySource("classpath:elements/customeraddele.yml")
@Getter
@Setter
public class CustomerAddEleProperties {
    private String agent;
    private String companyType;
    private String companyName;
    private String state;
    private String zipcode;
    private String address;
    private String referenceKey;
    private String vat;
    private String domainName;
    private String firstName;
    private String lastName;
    private String phone;
    private String mobile;
    private String email;
    private String nextStepBtn;
    private String cancelBtn;
    private String country;
    private String city;
    private String stepContainer;


    private String catagory;
    private String subSearchInput;
    private String subSearchBtn;
    private String subCheck;
    private String subNextBtn;
    private String subPreBtn;
    private String subCancelBtn;
    private String subSureBtn;
}
