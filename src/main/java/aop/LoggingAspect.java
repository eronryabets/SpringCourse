package aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution( public void get* (Book))")
    public void beforeBookAdvice(){
        System.out.println(
                "beforeGetBookAdvice: попытка получить книгу.");
    }

    @Before("execution( * returnBook())")
    public void beforeReturnBookAdvice(){
        System.out.println(
                "beforeGetBookAdvice: попытка вернуть книгу.");
    }

    @After("execution(public void returnBook())")
    public void afterReturnBookAdvice(){
        System.out.println(
                "beforeGetBookAdvice: книга возвращена.");
    }
}
