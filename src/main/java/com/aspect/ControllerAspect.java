package com.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


/**
 * @author Administrator
 * controller的aop
 */
@Component
@Aspect
@Order
public class ControllerAspect {

    Logger logger = Logger.getLogger(ControllerAspect.class);
    //配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点

    @Pointcut(("execution(public * com.controller.*.*(..))"))
    //切点位置为某个方法
    //@Pointcut("execution(* com.service.UserServiceImpl.update())")

    public void aspect() {
    }

    /**
     * @定义一个方法，用于声明切入点表达式，方法中一般不需要添加其他代码
     * @使用@Pointcut声明切入点表达式
     * @后面的通知直接使用方法名来引用当前的切点表达式；如果是其他类使用，加上包名即可
     */
    @Pointcut("execution(public * com.service.*Service.*(..))")
    public void declearJoinPointExpression() {
    }

    /**
     * @param joinPoint
     * @前置通知
     * @Before该标签声明次方法是一个前置通知：在目标方法开始之前执行
     */
    @Before("declearJoinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        logger.info("这个方法" + methodName + " begin. param<" + args + ">");

    }

    /**
     * @param joinPoint
     * @后置通知（无论方法是否发生异常都会执行,所以访问不到方法的返回值）
     */
    @After("declearJoinPointExpression()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("这个方法" + methodName + " end.");
    }

    /**
     * @param joinPoint
     * @返回通知（在方法正常结束执行的代码）
     * @返回通知可以访问到方法的返回值！
     */
    @AfterReturning(value = "declearJoinPointExpression()", returning = "result")
    public void afterReturnMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("这个方法" + methodName + " end.result<" + result + ">");
    }

    /**
     * @param joinPoint
     * @param ex
     * @异常通知（方法发生异常执行的代码）
     * @可以访问到异常对象；且可以指定在出现特定异常时执行的代码
     */
    @AfterThrowing(value = "declearJoinPointExpression()", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("这个方法" + methodName + " end.ex message<" + ex + ">");
    }

    /**
     * @param point
     * @环绕通知(需要携带类型为ProceedingJoinPoint类型的参数)
     * @环绕通知包含前置、后置、返回、异常通知；ProceedingJoinPoin，类型的参数可以决定是否执行目标方法
     * @且环绕通知必须有返回值，返回值即目标方法的返回值
     */
//    @Around(value = "declearJoinPointExpression()")
//    public Object aroundMethod(ProceedingJoinPoint point) {
//
//        Object result;
//        String methodName = point.getSignature().getName();
//        try {
//            /**前置通知*/
//            logger.info("这个方法" + methodName + " start. param<" + Arrays.asList(point.getArgs()) + ">");
//            /**执行目标方法*/
//            result = point.proceed();
//            /**返回通知*/
//            logger.info("这个方法" + methodName + " end. result<" + result + ">");
//        } catch (Throwable e) {
//            /**异常通知*/
//            logger.info("这个方法" + methodName + " end.ex message<" + e + ">");
//            throw new RuntimeException(e);
//        }
//        /**后置通知*/
//        logger.info("这个方法" + methodName + " end.");
//        return result;
//    }

}