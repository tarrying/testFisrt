package com.rcc.ecs.test.page.customer;

import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.config.properties.CustomerListEleProperties;
import com.rcc.ecs.test.page.BasePage;
import com.rcc.ecs.test.util.GetByLocator;
import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.config.properties.CustomerListEleProperties;
import com.rcc.ecs.test.page.BasePage;
import com.rcc.ecs.test.util.GetByLocator;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CustomerListPage extends BasePage {

    private CustomerListEleProperties customerEleProperties;
    public CustomerListPage(DriverBase driver, CustomerListEleProperties customerEleProperties){
        super(driver);
        this.customerEleProperties = customerEleProperties;
    }

    //
    public WebElement getInputGroupEle() {
        return webDriverWait(GetByLocator.getLocator(customerEleProperties.getInputGroup()),60,1);
    }

    //搜索内容 input
    public WebElement getSearchInputEle() {
        return element(getInputGroupEle(),GetByLocator.getLocator(customerEleProperties.getSearchInput()));
    }

    //搜索按钮
    public WebElement getSearchBtnEle() {
        return element(getInputGroupEle(),GetByLocator.getLocator(customerEleProperties.getSearchButton()));
    }

    //添加按钮
    public WebElement getAddBtnEle(){
        return webDriverWait(GetByLocator.getLocator(customerEleProperties.getDropDownMenu()),10,1);
    }

    //下拉选择框
    public WebElement getDropDownMenEle(){
        return webDriverWait(GetByLocator.getLocator(customerEleProperties.getDropDownLi()),10,1);
    }

    //客户列表
    public WebElement getCustTableEle() {
        return webDriverWait(GetByLocator.getLocator(customerEleProperties.getCustTable()),10,1);
    }

    //获取每一行最后一列即详情按钮
    public WebElement getCustInfoBtnEle(int row) {
        WebElement trEle = getTrElement(getCustTableEle(),row);
        if(null != trEle){
            List<WebElement> tdList = tdElements(trEle);
            int len = tdList.size();
            if(tdList.size() > 0){
                return tdList.get(len-1);
            }

        }
        return null;
    }

    //返回编辑按钮
    public WebElement getQuitEditBtn(){
        return element(GetByLocator.getLocator(customerEleProperties.getQuitEditBtn()));
    }

    //确认离开按钮
    public WebElement getSureBtnEle(){
        return webDriverWait(GetByLocator.getLocator(customerEleProperties.getSureBtn()),10,1);
    }
}
