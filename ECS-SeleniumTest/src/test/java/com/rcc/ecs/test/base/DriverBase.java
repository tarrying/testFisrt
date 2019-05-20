package com.rcc.ecs.test.base;

import com.rcc.ecs.test.config.WebDriverConfig;
import com.rcc.ecs.test.config.WebDriverConfig;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class DriverBase {


    private WebDriverConfig webDriverConfig;

    @Getter
    private WebDriver driver;


    @Autowired
    public DriverBase(WebDriverConfig webDriverConfig){
        this.webDriverConfig = webDriverConfig;
        this.driver = getDriver();
    }

    public void stop(){
        log.info("stop webdriver");
        driver.close();
    }

    public WebElement findElement(By by){
        WebElement element = driver.findElement(by);
        return element;
    }

    public List<WebElement> findElementList(By by){
        List<WebElement> elements = driver.findElements(by);
        return elements;
    }

    public void get(String url){
        driver.get(url);
    }

    public void back(){
        log.info("driver back");
        driver.navigate().back();
    }


    public String getWindowHandle(){
        return driver.getWindowHandle();
    }

    public void switchToWindow(String name){
        driver.switchTo().window(name);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void switchToMode(){
        log.info("switchToMode");
        driver.switchTo().activeElement();
    }

    public void action(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    /**
     * 获取cookies
     * @return
     */
    public Set<Cookie> getCookie(){
        Set<Cookie> cookies = driver.manage().getCookies();
        return cookies;
    }


    /**
     *  根据浏览器名称生成对应的Driver
     */
    private WebDriver getDriver(){
        WebDriver driver = null;
        String browser = webDriverConfig.getBrowserName();
        if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.firefox.marionette",webDriverConfig.getFirefoxPath());
            driver = new FirefoxDriver();
        }else{
            System.setProperty("webdriver.chrome.driver",webDriverConfig.getChromePath());
            driver = new ChromeDriver();
        }
        return driver;
    }

    //隐士等待
    public void implicitlyWait(long waitTime){
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

    //显示等待 获取元素
    public WebElement webDriverWait(By by, long waitTime,long sleepInMillis ){
        WebElement element = (new WebDriverWait(driver,waitTime,sleepInMillis))
                .until(ExpectedConditions.presenceOfElementLocated(by));
        return element;
    }


    /**
     * 自动截图
     * */
    public void takeScreenShot(String fileName) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String dateStr = sf.format(date);
        String path = fileName + "_" + dateStr + ".png";
        log.info(path);
        takeScreenShot((TakesScreenshot) this.driver, path);
        //takeScreenShot((TakesScreenshot) driver, path);
    }

    /**
     * 传入参数截图
     * */
    public void takeScreenShot(TakesScreenshot drivername, String path) {
        String currentPath = System.getProperty("user.dir"); // get current work
        File scrFile = drivername.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(currentPath + "\\" + webDriverConfig.getScreenImagePath()+ path));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("截图成功");
        }
    }


    //滚动条移动
    public void scroll(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }


    /**
     * 点击空白区域：坐标（0，0）
     */
    public void clickBlankArea() {
        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 0).click().build().perform();
    }

    public void jsExecute(String js) {
        ((JavascriptExecutor)driver).executeScript(js);
    }


    //使用键盘事件解决 input type=number类型的输入框输入值输入不进去的问题
    public void actionSendKeys(String value){
        Actions act=new Actions(driver);
        act.keyDown(Keys.CONTROL).sendKeys(value).keyUp(Keys.CONTROL).perform();
    }
}
