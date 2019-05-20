package com.rcc.ecs.test.util;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
public class GetByLocator {
    public static By getLocator(String key){
        String arr[] = key.split(">");
        if(null == arr || arr.length < 1){
            log.info("key is not exist");
        }
        String methodType = arr[0];
        String path = arr[1];
        if(methodType.equalsIgnoreCase("id")){
            return By.id(path);
        }else if(methodType.equalsIgnoreCase("name")){
            return By.name(path);
        }else if(methodType.equalsIgnoreCase("className")){
            return By.className(path);
        }else if(methodType.equalsIgnoreCase("tagName")){
            return By.tagName(path);
        }else if(methodType.equalsIgnoreCase("linkText")){
            return By.linkText(path);
        }else if(methodType.equalsIgnoreCase("partialLinkText")){
            return By.partialLinkText(path);
        }else{
            return By.xpath(path);
        }
    }
}
