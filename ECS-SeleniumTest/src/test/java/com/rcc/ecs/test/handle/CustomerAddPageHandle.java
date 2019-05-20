package com.rcc.ecs.test.handle;

import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.config.properties.CustomerAddEleProperties;
import com.rcc.ecs.test.config.properties.CustomerListEleProperties;
import com.rcc.ecs.test.page.customer.CustomerAddPage;
import com.rcc.ecs.test.page.customer.CustomerListPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@Slf4j
public class CustomerAddPageHandle {
    private CustomerAddPage customerAddPage;
    public CustomerAddPageHandle(DriverBase driver, CustomerAddEleProperties customerAddProperties){
        customerAddPage = new CustomerAddPage(driver, customerAddProperties);
    }

    //点击经销商下拉框，选中经销商
    public void chooseAgent(String value){
        WebElement element = customerAddPage.getAgentEle();
        Select downList = new Select(element);
        log.info(downList.getOptions().get(0).getText());
        downList.selectByVisibleText(value);
    }

    //公司类别
    public void chooseCompanyType(String value){
        WebElement element = customerAddPage.getCompanyTypeEle();
        Select downList = new Select(element);
        downList.selectByVisibleText(value);
    }

    //输入公司名称
    public void companyNameSendKey(String value){
        customerAddPage.sendKeys(customerAddPage.getCompanyNameEle(),value);
    }

    //城市选择
    public void chooseCity(int index){
        WebElement element = customerAddPage.getCityEle();
        Select downList = new Select(element);
        downList.selectByIndex(index);
    }

    //输入区域
    public void regionSendKey(String value){
        customerAddPage.sendKeys(customerAddPage.getStateEle(),value);
    }

    //输入邮政编码
    public void zipCodeSendKey(String value){
        customerAddPage.sendKeys(customerAddPage.getZipCode(),value);
    }

    //输入地址
    public void addressSendKey(String value){
        customerAddPage.sendKeys(customerAddPage.getAddressEle(),value);
    }

    //输入参考键
    public void referenceKeySendKey(String value){
        customerAddPage.sendKeys(customerAddPage.getReferenceKeyEle(),value);
    }

    //输入增值税号码
    public void vatSendKey(String value){
        customerAddPage.sendKeys(customerAddPage.getVatEle(),value);
    }

    //输入域名
    public void domainSendKey(String value) {
        customerAddPage.sendKeys(customerAddPage.getDomainNameEle(),value);
    }

    //输入姓
    public void firstNameSendKey(String value) {
        customerAddPage.sendKeys(customerAddPage.getFirsNameEle(), value);
    }

    //输入名
    public void lastNameSendKey(String value){
        customerAddPage.sendKeys(customerAddPage.getLastNameEle(), value);
    }

    //输入电话号码
    public void phoneSendKey(String value){
        customerAddPage.sendKeys(customerAddPage.getPhoneEle(), value);
    }

    //输入手机号码
    public void mobileSendKey(String value) {
        customerAddPage.sendKeys(customerAddPage.getMobileEle(),value);
    }

    //输入邮箱
    public void emailSendKey(String value){
        customerAddPage.sendKeys(customerAddPage.getEmailEle(),value);
    }

    //点击下一步
    public void clickNextBtn(){
        customerAddPage.click(customerAddPage.getNextBtnEle());
    }

    //移动滚动条
    public void scroll(){
        customerAddPage.scroll(customerAddPage.getStepContainerEle());
    }

    //点击空白页面
    public void clickBlankArea() {
        customerAddPage.clickBlankArea();
    }

    //选中订阅目录
    public void clickCategory(int index) {
        customerAddPage.click(customerAddPage.getCatagorysEle().get(index));
    }

    //输入搜索订阅名称
    public void subSearchInputSendKey(String value){
        customerAddPage.sendKeys(customerAddPage.getSubSearchInputEle(),value);
    }

    //点击搜索按钮
    public void clickSearchBtn(){
        customerAddPage.click(customerAddPage.getSubSearchBtnEle());
    }

    //选中订阅
    public String chooseSubscription(int index) {
        WebElement element = customerAddPage.getSubChecksEle().get(index);
        String subscrptionId = element.getAttribute("id");
        customerAddPage.click(element);
        return subscrptionId;
    }

    //点击确认添加按钮
    public void clickSubSureBtn(){
       // log.info(customerAddPage.getSubSureBtnEle().getText());
        //有时候没有确认提示框
        WebElement element = customerAddPage.getSubSureBtnEle();
        if(null != element && element.isDisplayed()){ //隐藏也能获取到
            customerAddPage.click(customerAddPage.getSubSureBtnEle());
        }
    }

    //输入许可证数量
    public void licenceNumSendKey(String id,String value){
       // WebElement element = customerAddPage.getLicenceNumEle(id);
      //  element.click();
      //  customerAddPage.actionSendKey(value);
        customerAddPage.sendKeys(customerAddPage.getLicenceNumEle(id),value);
    }

}
