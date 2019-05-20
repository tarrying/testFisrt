package com.rcc.ecs.test.page.login;

import com.rcc.ecs.test.config.properties.LoginEleProperties;
import com.rcc.ecs.test.util.GetByLocator;
import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.config.properties.LoginEleProperties;
import com.rcc.ecs.test.page.BasePage;
import com.rcc.ecs.test.util.GetByLocator;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    LoginEleProperties loginEleProperties;

    public LoginPage(DriverBase driver, LoginEleProperties loginEleProperties){
        super(driver);
        this.loginEleProperties = loginEleProperties;
    }

    public WebElement getLoginBtnEle(){
        return element(GetByLocator.getLocator(loginEleProperties.getLoginBtn()));
    }

    //登录邮件输入框
    public WebElement getEmailInput(){
        return element(GetByLocator.getLocator(loginEleProperties.getEmailInput()));
    }

    //下一步
    public WebElement getNextBtn(){
        return webDriverWait(GetByLocator.getLocator(loginEleProperties.getNextBtn()),3,1);
    }

    //密码输入框
    public WebElement getPasswdInput(){
        return element(GetByLocator.getLocator(loginEleProperties.getPasswdInput()));
    }

    //保持登录状态 不在显示此消息的checkbox
    public WebElement getChectBox(){
        return webDriverWait(GetByLocator.getLocator(loginEleProperties.getCheckBox()),3,1);
    }

}
