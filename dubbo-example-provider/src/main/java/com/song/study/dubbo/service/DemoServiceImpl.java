package com.song.study.dubbo.service;

import com.song.study.dubbo.api.DemoInterface;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

@DubboService
@Slf4j
public class DemoServiceImpl implements DemoInterface {
    @Value("${test:1}")
    private String test;

    @Value("${test0:0}")
    private String test0;

    @Value("${test2:2}")
    private String test2;

    @Override
    public String sayHello(String name) {
        log.info("test is: {}, test0 is: {}, test2 is: {}", test, test0, test2);
        return "Hello" + name + "-" + test;
    }
}
