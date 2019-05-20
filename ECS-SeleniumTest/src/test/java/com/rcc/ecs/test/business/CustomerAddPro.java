package com.rcc.ecs.test.business;

import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.config.properties.CustomerAddEleProperties;
import com.rcc.ecs.test.handle.CustomerAddPageHandle;
import com.rcc.ecs.test.page.customer.CustomerAddPage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerAddPro {
    private CustomerAddPageHandle customerAddPageHandle;
    private DriverBase driver;
    public CustomerAddPro(DriverBase driver, CustomerAddEleProperties customerAddEleProperties){
        this.driver = driver;
        customerAddPageHandle = new CustomerAddPageHandle(driver,customerAddEleProperties);
    }

    //新增客户输入基本信息
    public void addCustomerInfo() throws Exception{
        Thread.sleep(5000);
        driver.implicitlyWait(3);
        //滚动 滚动条
        customerAddPageHandle.scroll();
        //选择经销商
       customerAddPageHandle.chooseAgent("WiAdvance Partner Center Integration Sandbox");
        //选择公司类别
       customerAddPageHandle.chooseCompanyType("Customer");
        //输入公司名称
        String companyName = "rccTest"+System.currentTimeMillis();
        customerAddPageHandle.companyNameSendKey(companyName);
        // 选择城市
        customerAddPageHandle.chooseCity(1);
        //输入区域
        customerAddPageHandle.regionSendKey("台北");
        //输入邮政编码
        customerAddPageHandle.zipCodeSendKey("43020");
        //输入地址
        customerAddPageHandle.addressSendKey("台北");
        //输入账户参考键
        customerAddPageHandle.referenceKeySendKey("11111");
        //输入增值税号
        customerAddPageHandle.vatSendKey("111111");
        //输入域名
        customerAddPageHandle.domainSendKey(companyName);
        //鼠标离开点击空白页面 之后会去检查domain是否合法
        customerAddPageHandle.clickBlankArea();
        //域名校验需要时间 10秒钟
        Thread.sleep(10000);
        //输入姓
        customerAddPageHandle.firstNameSendKey("r");
        //输入名
        customerAddPageHandle.lastNameSendKey("cc");
        //输入电话号码
        customerAddPageHandle.phoneSendKey("123456789");
        //输入手机号
        customerAddPageHandle.mobileSendKey("18924426121");
        //输入邮箱
        customerAddPageHandle.emailSendKey("tarry_ruan@wistronits.com");
        //点击下一步
        customerAddPageHandle.clickNextBtn();
    }

    public void addSubInfo() throws Exception{
        //移动滚动条
        customerAddPageHandle.scroll();
        Thread.sleep(2000);
        //默认选中第一个目录
        customerAddPageHandle.clickCategory(0);
        //订阅查询需要时间
        Thread.sleep(3000);
        //默认选中第一个订阅
        String subscriptionId = customerAddPageHandle.chooseSubscription(0);

        //输入许可证1-10000000之间
        customerAddPageHandle.licenceNumSendKey(subscriptionId + "-input", "100");
        //点击下一步
        // customerAddPageHandle.clickSubNextBtn();
        customerAddPageHandle.clickNextBtn();
        Thread.sleep(1000);
        // driver.switchToMode();
        // String currentWindowHandle = driver.getWindowHandle();
        // driver.switchToWindow(currentWindowHandle);
        //确认添加 模态框定位正确了就可以点击到，不需要使用mode或者windowHandle
        customerAddPageHandle.clickSubSureBtn();
        //移动滚动条
        customerAddPageHandle.scroll();
        //点击提交按钮
        customerAddPageHandle.clickNextBtn();
    }
}
