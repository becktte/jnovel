package com.umbrella.jnovel.web.controller;

import com.umbrella.jnovel.system.annotation.Limit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Author becktte
 * @Date 2019/4/16
 * @Version 1.0
 **/
@RestController
@RequestMapping("/limit")
public class LimitController {

    private final AtomicInteger atomicInteger = new AtomicInteger();

    @RequestMapping("/test")
    @Limit(period = 100, count = 10, key = "test")
    public int test() {
        return atomicInteger.incrementAndGet();
    }
}
