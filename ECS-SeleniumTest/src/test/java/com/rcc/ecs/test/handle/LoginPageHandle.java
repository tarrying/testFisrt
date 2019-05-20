package com.rcc.ecs.test.handle;

import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.config.properties.LoginEleProperties;
import com.rcc.ecs.test.page.login.LoginPage;

public class LoginPageHandle {

    LoginPage loginPage;
    DriverBase driver;
    public LoginPageHandle(DriverBase driver, LoginEleProperties loginEleProperties){
        this.driver = driver;
        this.loginPage = new LoginPage(driver,loginEleProperties);
    }

    //点击登录按钮进入登录页面
    public void clickLoginBtn(){
        loginPage.click(loginPage.getLoginBtnEle());
    }

    //输入用户名
    public void sendKeyUserName(String username){
        loginPage.sendKeys( loginPage.getEmailInput(),username);
    }

    //点击下一步
    public void clickNextBtn(){
        loginPage.click(loginPage.getNextBtn());
    }

    //输入密码
    public void sendKeyPasswd(String password){
        loginPage.sendKeys(loginPage.getPasswdInput(),password);
    }


    //点击不在显示此消息
    public void clickCheckBox() {
        System.out.println(loginPage.getChectBox());
        loginPage.click(loginPage.getChectBox());
    }

}
