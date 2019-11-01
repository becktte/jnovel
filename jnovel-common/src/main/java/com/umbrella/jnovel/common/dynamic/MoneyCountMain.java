package com.umbrella.jnovel.common.dynamic;

import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author becktte
 * @Date 2019/9/25
 * @Version 1.0
 **/
public class MoneyCountMain {

    public static void main(String[] args) throws InterruptedException {
        SmsService smsService = new SmsServiceImpl();
        smsService = (SmsService) Proxy.newProxyInstance(SmsServiceImpl.class.getClassLoader(),
                new Class[] {SmsService.class},
                new MoneyCountInvocationHandler(smsService));
        for (;;) {
            Thread.sleep(1000);
            smsService.sendMessage();
        }
    }
}
