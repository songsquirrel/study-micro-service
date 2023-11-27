package com.basic.config.lock.aop;

import com.basic.config.lock.annotation.DistributedLock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * 分布式锁aop
 */
@Component
public class DistributedLockAop {
    @Resource
    private RedissonClient redissonClient;

    @Pointcut("@annotation(com.basic.config.lock.annotation.DistributedLock)")
    public void distributedLockAspect() {
    }

    @Around("distributedLockAspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        /// 生成锁的key，采用@DistributedLock注解中的key值
        // 切点所在的类
        Class<?> targetClass = pjp.getTarget().getClass();
        // 切点所在的方法名称
        String methodName = pjp.getSignature().getName();
        Class<?>[] parameterTypes = ((MethodSignature) pjp.getSignature()).getMethod().getParameterTypes();
        Object[] args = pjp.getArgs();
        // 获取切点所在的方法
        Method method = targetClass.getMethod(methodName, parameterTypes);
        return null;
    }


    private RLock lock(String lockName, DistributedLock distributedLock) throws InterruptedException {
        RLock lock = redissonClient.getLock(lockName);
        int leaseTime = distributedLock.leaseTime();
        if (distributedLock.retry()) {
            lock.tryLock(distributedLock.waitTime(), leaseTime, distributedLock.timeUnit());
        } else {
            if (leaseTime > 0) {
                lock.lock(leaseTime, distributedLock.timeUnit());
            } else {
                lock.lock();
            }
        }
        return lock;
    }

}
