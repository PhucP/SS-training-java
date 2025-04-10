package phucnh.qlbh.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RunAOP {
    private Logger logger = Logger.getLogger(RunAOP.class.getName());
    @Around("execution(* phucnh.qlbh.aop.TestAOP.showPersonInfo.*(..))")
    public Object logWithAnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info(joinPoint.toString() + "method execution start");
        Object result = joinPoint.proceed();
        logger.info(joinPoint.toString() + "method execution end");
        return result;
    }

    @Before("execution(* phucnh.qlbh.aop.TestAOP.read(..))")
    public void logReading(JoinPoint joinPoint) {
        System.out.println("log before reading");
        joinPoint.getSignature();
    }


    @After("execution(* phucnh.qlbh.aop.TestAOP.wirte(..))")
    public void logWriting(JoinPoint joinPoint) {
        joinPoint.getSignature();
        System.out.println("log after writing");
    }
}
