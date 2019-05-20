package com.rcc.ecs.test.page.customer;

import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.config.properties.CustomerAddEleProperties;
import com.rcc.ecs.test.page.BasePage;
import com.rcc.ecs.test.util.GetByLocator;
import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.config.properties.CustomerAddEleProperties;
import com.rcc.ecs.test.page.BasePage;
import com.rcc.ecs.test.util.GetByLocator;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@Slf4j
public class CustomerAddPage extends BasePage {
    private CustomerAddEleProperties customerAddEleProperties;
    public CustomerAddPage(DriverBase driver, CustomerAddEleProperties customerAddEleProperties){
        super(driver);
        this.customerAddEleProperties = customerAddEleProperties;
    }
    //经销商
    public WebElement getAgentEle(){
        WebElement element = element(GetByLocator.getLocator(customerAddEleProperties.getAgent()));
        return element;
    }

    //公司类别
    public WebElement getCompanyTypeEle() {
        return element(GetByLocator.getLocator(customerAddEleProperties.getCompanyType()));
    }

    //公司名称
    public WebElement getCompanyNameEle() {
        return element(GetByLocator.getLocator(customerAddEleProperties.getCompanyName()));
    }

    //国家
    public WebElement getContryEle(){
        return element(GetByLocator.getLocator(customerAddEleProperties.getCountry()));
    }

    //城市
    public WebElement getCityEle() {
        return element(GetByLocator.getLocator(customerAddEleProperties.getCity()));
    }
    //区域
    public WebElement getStateEle() {
        return element(GetByLocator.getLocator(customerAddEleProperties.getState()));
    }

    //邮政编号
    public WebElement getZipCode() {
        return element(GetByLocator.getLocator(customerAddEleProperties.getZipcode()));
    }

    //地址
    public WebElement getAddressEle() {
        return element(GetByLocator.getLocator(customerAddEleProperties.getAddress()));
    }

    //账户参考键
    public WebElement getReferenceKeyEle() {
        return element(GetByLocator.getLocator(customerAddEleProperties.getReferenceKey()));
    }

    //增值税号
    public WebElement getVatEle(){
        return element(GetByLocator.getLocator(customerAddEleProperties.getVat()));
    }

    //域名
    public WebElement getDomainNameEle() {
        return element(GetByLocator.getLocator(customerAddEleProperties.getDomainName()));
    }

    //姓
    public WebElement getFirsNameEle(){
        return element(GetByLocator.getLocator(customerAddEleProperties.getFirstName()));
    }

    //名
    public WebElement getLastNameEle() {
        return element(GetByLocator.getLocator(customerAddEleProperties.getLastName()));
    }

    //电话号码
    public WebElement getPhoneEle() {
        return element(GetByLocator.getLocator(customerAddEleProperties.getPhone()));
    }

    //手机号
    public WebElement getMobileEle() {
        return element(GetByLocator.getLocator(customerAddEleProperties.getMobile()));
    }

    //邮箱
    public WebElement getEmailEle() {
        return element(GetByLocator.getLocator(customerAddEleProperties.getEmail()));
    }

    //下一步按钮
    public WebElement getNextBtnEle() {
        log.info(customerAddEleProperties.getNextStepBtn());
        return webDriverWait(GetByLocator.getLocator(customerAddEleProperties.getNextStepBtn()),10,1);
    }

    //取消按钮
    public WebElement getCancelBtnEle() {
        return element(GetByLocator.getLocator(customerAddEleProperties.getCancelBtn()));
    }

    public WebElement getStepContainerEle() {
        return webDriverWait(GetByLocator.getLocator(customerAddEleProperties.getStepContainer()),10,1);
    }

    //目录
    public List<WebElement> getCatagorysEle(){
        return elements(GetByLocator.getLocator(customerAddEleProperties.getCatagory()));
    }

    //订阅搜索输入框
    public WebElement getSubSearchInputEle(){
        return element(GetByLocator.getLocator(customerAddEleProperties.getSubSearchInput()));
    }

    //订阅搜索按钮
    public WebElement getSubSearchBtnEle(){
        return element(GetByLocator.getLocator(customerAddEleProperties.getSubSearchBtn()));
    }

    //订阅选项
    public List<WebElement> getSubChecksEle(){
        return elements(GetByLocator.getLocator(customerAddEleProperties.getSubCheck()));
    }

    //新增订阅确认按钮
    public WebElement getSubSureBtnEle(){
        try {
            WebElement element = webDriverWait(GetByLocator.getLocator(customerAddEleProperties.getSubSureBtn()),5,1);
            return element;
        }catch (Exception e){
            log.info("没有新增订阅确认按钮");
        }
       return null;
    }

    //许可证数量
    public WebElement getLicenceNumEle(String id) {
        String by = "id>"+id;
        WebElement element = element(GetByLocator.getLocator(by));
        return element;
    }
}
