package com.rcc.ecs.test.testcase.login;

;
import com.rcc.ecs.test.business.LoginPro;
import com.rcc.ecs.test.config.properties.CustomerListEleProperties;
import com.rcc.ecs.test.config.properties.LoginEleProperties;
import com.rcc.ecs.test.listener.TestngListenerScreenShot;
import com.rcc.ecs.test.testcase.BaseTest;
import com.rcc.ecs.test.business.LoginPro;
import com.rcc.ecs.test.config.properties.CustomerListEleProperties;
import com.rcc.ecs.test.config.properties.LoginEleProperties;
import com.rcc.ecs.test.listener.TestngListenerScreenShot;
import com.rcc.ecs.test.testcase.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({TestngListenerScreenShot.class})
@Slf4j
public class LoginTest extends BaseTest {

    @Autowired
    LoginEleProperties loginEleProperties;
    @Autowired
    CustomerListEleProperties customerEleProperties;
    @Test
    public void login() throws Exception{
        log.info("哈哈哈  先登录");
        //登录
        driver.get(ecsProperties.getHost()+ecsProperties.getLogin());
        //  driver.get("http://www.baidu.com");
        driver.implicitlyWait(5);
        LoginPro loginPro = new LoginPro(driver,loginEleProperties);
        loginPro.login("in.xu@wiadvance.com","P@ssword123");

    }

}
