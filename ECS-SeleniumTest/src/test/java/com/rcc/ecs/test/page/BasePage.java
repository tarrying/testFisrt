package com.rcc.ecs.test.page;

import com.rcc.ecs.test.util.GetByLocator;
import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.util.GetByLocator;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

@Slf4j
public class BasePage {

    public DriverBase driver;

    public BasePage(DriverBase driver){
        this.driver = driver;
    }
    /**
     * 获取元素
     * @param by
     * @return
     */
    public WebElement element(By by) {
        WebElement element = driver.findElement(by);
        return element;
    }


    /**
     * 获取元素
     * @param by
     * @return
     */
    public List<WebElement> elements(By by) {
        List<WebElement> elements = driver.findElementList(by);
        return elements;
    }

    /**
     * 获取元素
     * @param ele
     * @param by
     * @return
     */
    public WebElement element(WebElement ele, By by){
        WebElement element = ele.findElement(by);
        return element;
    }


    /**
     * 获取多个元素
     * @param ele
     * @param by
     * @return
     */
    public List<WebElement> elements(WebElement ele, By by){
        List<WebElement> elements = ele.findElements(by);
        return elements;
    }
    /**
     * 获取元素
     * @param by
     * @param nodeBy
     * @return
     */
    public WebElement element(By by, By nodeBy){
        WebElement element = this.element(by);
        return this.element(element, nodeBy);
    }

    public List<WebElement> elements(By by, By nodeBy){
        WebElement element = this.element(by);
        return this.elements(element, nodeBy);
    }
    /**
     * click 事件
     * @param findElement
     */
    public void click(WebElement findElement){
        if(null != findElement){
            findElement.click();
        }else{
            log.info("Element is null");
        }
    }

    /**
     * 输入内容
     * @param element
     * @param value
     */
    public void sendKeys(WebElement element, String value){
        if(null != element){
            element.sendKeys(value);
        }else{
            log.info(element + "no" + value);
        }
    }

    public void forSendKeys(WebElement element, String content) {
        if(null != element){
            element.clear();
            for (int i=0;i< content.length(); i++){
                element.sendKeys(content.charAt(i)+"");
            }
        }else{
            log.info(element + "no element");
        }

    }

    /**
     * 查看元素是否存在
     * @param element
     * @return
     */
    public boolean assertElementIs(WebElement element){
        return element.isDisplayed();
    }

    /**
     * 获取元素上的内容
     * @param element
     * @return
     */
    public String getText(WebElement element){
        return element.getText();
    }

    public void action(WebElement element){
        driver.action(element);
    }

    public WebElement webDriverWait(By by, long waitTime,long sleepInMillis){
       return driver.webDriverWait(by,waitTime,sleepInMillis);
    }

    //滚动条移动
    public void scroll(WebElement element){
        driver.scroll(element);
    }
    /**
     * 点击空白区域：坐标（0，0）
     */
    public void clickBlankArea() {
        driver.clickBlankArea();
    }

    /**
     *  显示等待
     */
    public void implicitlyWait(long waitTime){
        driver.implicitlyWait(waitTime);
    }

    public void jsExecute(String js){
        driver.jsExecute(js);
    }

    public void actionSendKey(String value){
        driver.actionSendKeys(value);
    }

    /***                表格处理   ************/

    //获取行
    public List<WebElement> trElements(WebElement table){
        return table.findElements(GetByLocator.getLocator("tagName>tr"));
    }
    //获取列
    public List<WebElement> tdElements(WebElement tr){
        tr.getText();
        return tr.findElements(GetByLocator.getLocator("tagName>td"));
    }
    //获取第几行
    public WebElement getTrElement(WebElement table,int row){
        List<WebElement> list =  this.trElements(table);
        if(null != list && list.size() >= row){
            return list.get(row-1);
        }else {
            return null;
        }
    }
    //行数
    public int getTrCount(WebElement table){
        List<WebElement> list =  this.trElements(table);
        if(null != list){
            return list.size();
        }
        return 0;
    }

    //列数
    public int getTdCount(WebElement tr){
        List<WebElement> list = this.tdElements(tr);
        if(null != list){
            return list.size();
        }
        return 0;
    }

}
