package com.rcc.ecs.test.business;

import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.config.properties.LoginEleProperties;
import com.rcc.ecs.test.handle.LoginPageHandle;
import com.rcc.ecs.test.listener.TestngListenerScreenShot;
import org.testng.annotations.Listeners;

@Listeners({TestngListenerScreenShot.class})
public class LoginPro {

    private LoginPageHandle loginPageHandle;
    DriverBase driver;
    public LoginPro(DriverBase driver, LoginEleProperties loginEleProperties){
        this.driver = driver;
        this.loginPageHandle = new LoginPageHandle(driver,loginEleProperties);
    }

    public void login(String username,String password) throws Exception{
        //点击登录按钮
        loginPageHandle.clickLoginBtn();
        //输入用户名
        loginPageHandle.sendKeyUserName(username);
        //点击下一步
        loginPageHandle.clickNextBtn();
    //    driver.implicitlyWait(2000);
        //输入密码
        loginPageHandle.sendKeyPasswd(password);
        Thread.sleep(2000);
        //登录
        loginPageHandle.clickNextBtn();

        //保持登录状态 不在提示此消息
        loginPageHandle.clickCheckBox();
        Thread.sleep(2000);
        //保持登录状态
        loginPageHandle.clickNextBtn();
       // loginPageHandle.clickNextBtn();
    }
}
