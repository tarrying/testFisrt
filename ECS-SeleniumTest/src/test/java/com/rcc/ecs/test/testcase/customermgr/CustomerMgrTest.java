package com.rcc.ecs.test.testcase.customermgr;

import com.rcc.ecs.test.business.CustomerAddPro;
import com.rcc.ecs.test.business.CustomerListPro;
import com.rcc.ecs.test.business.MenuPro;
import com.rcc.ecs.test.config.properties.CustomerListEleProperties;
import com.rcc.ecs.test.testcase.BaseTest;
import com.rcc.ecs.test.business.CustomerAddPro;
import com.rcc.ecs.test.business.CustomerListPro;
import com.rcc.ecs.test.business.MenuPro;
import com.rcc.ecs.test.config.properties.CustomerAddEleProperties;
import com.rcc.ecs.test.config.properties.CustomerListEleProperties;
import com.rcc.ecs.test.config.properties.MenuProperties;
import com.rcc.ecs.test.listener.TestngListenerScreenShot;
import com.rcc.ecs.test.testcase.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestngListenerScreenShot.class})
@Slf4j
public class CustomerMgrTest extends BaseTest {
    //搜索客户
    @Autowired
    CustomerListEleProperties customerEleProperties;
    @Autowired
    CustomerAddEleProperties customerAddEleProperties;
    @Autowired
    MenuProperties menuProperties;
    private CustomerListPro customerMgrPro;
    private CustomerAddPro customerAddPro;
    @BeforeClass
    public void beforeClass() {
        customerMgrPro = new CustomerListPro(driver,customerEleProperties);
        customerAddPro = new CustomerAddPro(driver,customerAddEleProperties);
    }

   // @Test
    public void searchCustomer() throws Exception{
       log.info("搜索客户了");
       driver.implicitlyWait(5);
        //搜索客户
        Thread.sleep(3000);
        customerMgrPro.searchCustomer("rcc");
    }

    //查看客户详情
    public void getCustomerInfo() throws Exception{
        log.info("查看客户详情");
        Thread.sleep(3000);
        //查看客户详情
        customerMgrPro.customerInfo(2);
        customerMgrPro.quitEdit();
        //新增客户
        customerMgrPro.addCustomer();
    }

    @Test
    public void cusSubscription() throws Exception{
        log.info("/跳转到客户订阅页面");
        //跳转到客户订阅页面
        Thread.sleep(10000);
        MenuPro menuPro = new MenuPro(driver, menuProperties);
        menuPro.goToCusDataMgr();
    }

    //新增客户
    public void addCustomer() throws Exception{
        log.info("新增客户");

        Thread.sleep(3);
        //添加用户信息
        customerAddPro.addCustomerInfo();
        //添加订阅信息
        customerAddPro.addSubInfo();
    }
}
