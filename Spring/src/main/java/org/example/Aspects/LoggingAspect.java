package org.example.Aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* org.example.Publisher_Subscribe.ContextMenu.subscribe(..))")
    public void logBeforeSubscribe() {
        System.out.println("Перед выполнением метода subscribe");
    }

    @After("execution(* org.example.Publisher_Subscribe.ContextMenu.subscribe(..))")
    public void logAfterSubscribe() {
        System.out.println("После выполнения метода subscribe");
    }

    @AfterReturning("execution(* org.example.Publisher_Subscribe.ContextMenu.subscribe(..))")
    public void afterReturningSubscribeAdvice() {
        System.out.println("After successfully subscribing");
    }

    @Before("execution(* org.example.Publisher_Subscribe.ContextMenu.unsubscribe(..))")
    public void logBeforeUnsubscribe() {
        System.out.println("Перед выполнением метода unsubscribe");
    }

    @After("execution(* org.example.Publisher_Subscribe.ContextMenu.unsubscribe(..))")
    public void logAfterUnsubscribe() {
        System.out.println("После выполнения метода unsubscribe");
    }

    @AfterReturning("execution(* org.example.Publisher_Subscribe.ContextMenu.unsubscribe(..))")
    public void afterReturningUnsubscribeAdvice() {
        System.out.println("After successfully unsubscribing");
    }

    @Before("execution(* org.example.Factory_SingleTon_Composite.CompositeMenuItem.addChild(..))")
    public void logBeforeAddChild() {
        System.out.println("Перед выполнением метода addChild");
    }

    @After("execution(* org.example.Factory_SingleTon_Composite.CompositeMenuItem.addChild(..))")
    public void logAfterAddChild() {
        System.out.println("После выполнения метода addChild");
    }

    @Before("execution(* org.example.Factory_SingleTon_Composite.CompositeMenuItem.removeChild(..))")
    public void logBeforeRemoveChild() {
        System.out.println("Перед выполнением метода removeChild");
    }

    @After("execution(* org.example.Factory_SingleTon_Composite.CompositeMenuItem.removeChild(..))")
    public void logAfterRemoveChild() {
        System.out.println("После выполнения метода removeChild");
    }

    @Before("execution(* org.example.Publisher_Subscribe.ContextMenu.notifySubscribers(..))")
    public void logBeforeNotifySubscribers() {
        System.out.println("Перед выполнением метода notifySubscribers");
    }

    @After("execution(* org.example.Publisher_Subscribe.ContextMenu.notifySubscribers(..))")
    public void logAfterNotifySubscribers() {
        System.out.println("После выполнения метода notifySubscribers");
    }

    @AfterReturning("execution(* org.example.Publisher_Subscribe.ContextMenu.notifySubscribers(..))")
    public void afterReturningNotifySubscribersAdvice() {
        System.out.println("After successfully notifying subscribers");
    }
    @Before("execution(* org.example.Publisher_Subscribe.ContextMenu.setState(..))")
    public void logBeforeSetState() {
        System.out.println("Перед выполнением метода setState");
    }

    @After("execution(* org.example.Publisher_Subscribe.ContextMenu.setState(..))")
    public void logAfterSetState() {
        System.out.println("После выполнения метода setState");
    }

    @AfterReturning("execution(* org.example.Publisher_Subscribe.ContextMenu.setState(..))")
    public void afterReturningSetStateAdvice() {
        System.out.println("After successfully setting state");
    }
}
