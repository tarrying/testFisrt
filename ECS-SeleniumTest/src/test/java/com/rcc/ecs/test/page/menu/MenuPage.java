package com.rcc.ecs.test.page.menu;

import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.page.BasePage;
import com.rcc.ecs.test.util.GetByLocator;
import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.config.properties.MenuProperties;
import com.rcc.ecs.test.page.BasePage;
import com.rcc.ecs.test.util.GetByLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MenuPage extends BasePage {
    private MenuProperties menuProperties;
    public MenuPage(DriverBase driver, MenuProperties menuProperties) {
        super(driver);
        this.menuProperties = menuProperties;
    }

    //客户资料管理
    public WebElement getCusDataMgrEle() {
        return element(GetByLocator.getLocator(menuProperties.getCusDataMgr()));
    }

    //客户订阅管理
    public WebElement getCusSubMgrEle() {
        return element(GetByLocator.getLocator(menuProperties.getCusSubMgr()));
    }
}
