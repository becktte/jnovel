package com.umbrella.jnovel.common.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author becktte
 * @Date 2019/9/25
 * @Version 1.0
 **/
public class MoneyCountInvocationHandler implements InvocationHandler {

    /**
     * 被代理对象
     */
    private Object target;
    /**
     * 金额
     */
    private BigDecimal moneyCount;

    public MoneyCountInvocationHandler(Object target) {
        this.target = target;
        this.moneyCount = BigDecimal.ZERO;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        moneyCount = moneyCount.add(new BigDecimal(0.07));
        System.out.println("短信发送成功,总金额为" + moneyCount.toString() + "￥");
        Object result = method.invoke(target, args);
        return result;
    }
}
