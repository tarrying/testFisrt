package com.rcc.ecs.test.listener;

import lombok.extern.slf4j.Slf4j;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@Slf4j
public class TestngRetry  implements IRetryAnalyzer {

    private static  int retryCount         = 1;         // 定义重跑次数
    private static final int maxRetryCount = 3;         // 定义最大重跑次数

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount){
            log.error("retryCount" , retryCount);
            retryCount ++;
            return true;
        }
        return false;
    }
}
