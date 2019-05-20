package com.rcc.ecs.test.testcase;

import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.config.properties.EcsProperties;
import com.rcc.ecs.test.listener.TestngListenerScreenShot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.sql.Driver;


@Slf4j
@SpringBootTest
public class BaseTest extends AbstractTestNGSpringContextTests  {
    @Autowired
    public DriverBase driver;
    @Autowired
    public EcsProperties ecsProperties;
    public void takeScreenShot(String fileName){
       driver.takeScreenShot(fileName);
    }

}
