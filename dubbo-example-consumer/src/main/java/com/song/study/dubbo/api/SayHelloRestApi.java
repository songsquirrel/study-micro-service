package com.song.study.dubbo.api;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * restful api
 */
@RestController
@RequestMapping("restApi")
public class SayHelloRestApi {

    @DubboReference
    private DemoInterface demoInterface;

    @GetMapping("sayHello")
    public String sayHello(String name){
        return demoInterface.sayHello(name);
    }
}
