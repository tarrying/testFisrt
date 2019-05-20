package com.rcc.ecs.test.business;

import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.config.properties.MenuProperties;
import com.rcc.ecs.test.handle.MenuPageHandle;

public class MenuPro {
    private MenuPageHandle menuPageHandle;

    public MenuPro(DriverBase driver, MenuProperties menuProperties){
        menuPageHandle = new MenuPageHandle(driver,menuProperties);
    }

    //点击客户资料管理菜单
    public void goToCusDataMgr(){
        menuPageHandle.clickCusDataMenu();
    }

}
