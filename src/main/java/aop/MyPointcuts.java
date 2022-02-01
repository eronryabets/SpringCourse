package aop;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    //@Pointcut("execution( * add*(..))")
    @Pointcut("execution( * abcd*(..))")
    public void allAddMethods(){}
}
