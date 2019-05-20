package com.rcc.ecs.test.handle;

import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.config.properties.CustomerListEleProperties;
import com.rcc.ecs.test.page.customer.CustomerListPage;

public class CustomerListPageHandle {
    private CustomerListPage customerMgrPage;
    public CustomerListPageHandle(DriverBase driver, CustomerListEleProperties customerEleProperties){
        customerMgrPage = new CustomerListPage(driver, customerEleProperties);
    }

    //输入搜索内容
    public void searchInputSendKey(String content){
        customerMgrPage.sendKeys(customerMgrPage.getSearchInputEle(),content);
    }

    //点击搜索按钮
    public void clickSearchBtn(){
        customerMgrPage.click(customerMgrPage.getSearchBtnEle());
    }

    //点击新增按钮
    public void clickAddBtn() {
        customerMgrPage.click(customerMgrPage.getAddBtnEle());
    }

    //选中新增客户的选项
    public void clickAddCustomer() {
        customerMgrPage.click(customerMgrPage.getDropDownMenEle());
    }

    //查看客户详情
    public void clickCusInfo(int row){
        customerMgrPage.click(customerMgrPage.getCustInfoBtnEle(row));
    }

    //点击返回按钮
     public void clickQuitEditBtn(){
         customerMgrPage.click(customerMgrPage.getQuitEditBtn());
    }

    //点击确认离开编辑按钮
    public void clickSureBtn(){
        customerMgrPage.click(customerMgrPage.getSureBtnEle());
    }
}
