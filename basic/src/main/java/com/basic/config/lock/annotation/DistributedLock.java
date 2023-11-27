package com.basic.config.lock.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 分布式锁注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DistributedLock {
    /**
     * 锁的key
     * @return key
     */
    String key();

    /**
     * 锁超时释放时间
     * @return 锁超时释放时间，default 8
     */
    int leaseTime() default 8;

    /**
     * 时间单位
     * @return 时间单位，default second
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

    /**
     * 是否重试
     * @return 是否重试，default false
     */
    boolean retry() default false;

    /**
     * 锁的重试次数
     * @return 重试次数，default 3
     */
    int retryTimes() default 3;

    /**
     * 锁的重试间隔时间
     * @return 重试间隔时间，default 2
     */
    int waitTime() default 2;
}
