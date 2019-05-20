package com.rcc.ecs.test.handle;

import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.config.properties.MenuProperties;
import com.rcc.ecs.test.page.menu.MenuPage;
import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.config.properties.MenuProperties;
import com.rcc.ecs.test.page.menu.MenuPage;
import com.rcc.ecs.test.util.GetByLocator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class MenuPageHandle {
    private MenuPage menuPage;
    private DriverBase driver;
    public MenuPageHandle(DriverBase driver, MenuProperties menuProperties){
        this.driver = driver;
        this.menuPage = new MenuPage(driver,menuProperties);
    }

    //点击客户资料管理菜单
    public void clickCusDataMenu() {
        //menuPage.getCusDataMgrEle().sendKeys(Keys.ENTER);
        WebElement element = menuPage.getCusDataMgrEle();
     //   element.findElement(GetByLocator.getLocator("xpath>..")).click();
        System.out.println(element.getTagName());
        System.out.println(element.getText());
        System.out.println("=========="+element.isDisplayed());
        driver.action(element);
        menuPage.click(element);
       // element.sendKeys(Keys.ENTER);
    }

    //点击客户订阅管理菜单
    public void clickCusSubMenu() {
        menuPage.click(menuPage.getCusSubMgrEle());
    }
}
