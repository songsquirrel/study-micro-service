package com.song.study.dubbo.service;

import com.song.study.dubbo.api.DemoInterface;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class DemoServiceImpl implements DemoInterface {
    @Override
    public String sayHello(String name) {
        return "Hello" + name;
    }
}
