package com.rcc.ecs.test.listener;

import com.rcc.ecs.test.testcase.BaseTest;
import com.rcc.ecs.test.base.DriverBase;
import com.rcc.ecs.test.testcase.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.sql.Driver;
import java.util.Iterator;

/**
 * 监听
 */
@Slf4j
public class TestngListenerScreenShot extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        super.onTestSuccess(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        super.onTestFailure(iTestResult);
        this.takeScreenShot(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        super.onTestSkipped(iTestResult);
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        super.onStart(iTestContext);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
     //   super.onFinish(iTestContext);
        removeFailed(iTestContext);
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        super.onTestStart(iTestResult);
    }

    public void takeScreenShot(ITestResult tr){
        BaseTest base = (BaseTest) tr.getInstance();
        String fileName = tr.getMethod().getMethodName();
        log.error(fileName + "test failure to take screen shot");
        base.takeScreenShot(fileName);
    }

    private void removeFailed(ITestContext context) {
        Iterator<ITestResult> iterator = context.getFailedTests().getAllResults().iterator();

        while (iterator.hasNext()) {
            ITestResult failedTest = iterator.next();
            ITestNGMethod method = failedTest.getMethod();
            if (context.getFailedTests().getResults(method).size() > 1) {
                iterator.remove();
            } else {
                if (context.getPassedTests().getResults(method).size() > 0) {
                    iterator.remove();
                }
            }
        }
    }
}
