//package com.song.study.dubbo;
//
//import com.song.study.dubbo.api.DemoInterface;
//import org.apache.dubbo.config.annotation.DubboReference;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class Task implements CommandLineRunner {
//    @DubboReference
//    private DemoInterface demoInterface;
//
//    @Override
//    public void run(String... args) throws Exception {
//        String result = demoInterface.sayHello(", world");
//        System.out.println("receive result =====> " + result);
//
//        new Thread(()-> {
//            while (true) {
//                try {
//                    Thread.sleep(1000);
//                    System.out.println(new Date() + " Receive result ======> " + demoInterface.sayHello("world"));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    Thread.currentThread().interrupt();
//                }
//            }
//        }).start();
//    }
//}
