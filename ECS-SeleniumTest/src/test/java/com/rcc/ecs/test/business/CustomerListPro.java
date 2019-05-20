package com.rcc.ecs.test.business;

import com.rcc.ecs.test.handle.CustomerListPageHandle;
import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.config.properties.CustomerListEleProperties;
import com.rcc.ecs.test.handle.CustomerListPageHandle;

public class CustomerListPro {

    private CustomerListPageHandle customerMgrPageHandle;

    public CustomerListPro(DriverBase driver, CustomerListEleProperties customerEleProperties) {
        customerMgrPageHandle = new CustomerListPageHandle(driver, customerEleProperties);
    }

    //搜索客户
    public void searchCustomer(String content) {
        customerMgrPageHandle.searchInputSendKey(content);
        customerMgrPageHandle.clickSearchBtn();
    }

    //新增客户
    public void addCustomer() throws Exception{
        customerMgrPageHandle.clickAddBtn();
        Thread.sleep(3);
        customerMgrPageHandle.clickAddCustomer();
    }

    //查看客户详情
    public void customerInfo(int row){
        customerMgrPageHandle.clickCusInfo(row);
    }

    //从客户详情返回到客户列表页面
    public void quitEdit(){
        customerMgrPageHandle.clickQuitEditBtn();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        customerMgrPageHandle.clickSureBtn();
    }

}
