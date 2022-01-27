package aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {

    @Pointcut("execution(* aop.UniLibrary.get*())")
    public void allGetMethodFromUniLibrary(){}

    @Pointcut("execution(* aop.UniLibrary.return*())")
    public void allReturnMethodFromUniLibrary(){}

    @Pointcut ("allGetMethodFromUniLibrary() || allReturnMethodFromUniLibrary()")
    private void allGetAndReturnMethodFromUniLibrary(){}


    @Before("allGetMethodFromUniLibrary()")
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: writing Log #1");
    }

    @Before("allReturnMethodFromUniLibrary()")
    public void beforeReturnLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: writing Log #2");
    }

    @Before("allGetMethodFromUniLibrary() || allReturnMethodFromUniLibrary()")
    public void beforeGetAndReturnLoggingAdvice(){
        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log #3");
    }











































//    @Pointcut("execution( * get* ())")
//    private void allGetMethods(){}
//
//    @Before("allGetMethods()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetBookAdvice: " +
//                "попытка получить книгу/журнал.");
//    }
//
//    @Before("allGetMethods()")
//    public void beforeGetSecurityAdvice(){
//        System.out.println("beforeGetSecurityAdvice: " +
//                "проверка прав на получение книги/журнала.");
//    }


//    @Before("execution( * returnBook())")
//    public void beforeReturnBookAdvice(){
//        System.out.println(
//                "beforeGetBookAdvice: попытка вернуть книгу.");
//    }
//
//    @After("execution(public void returnBook())")
//    public void afterReturnBookAdvice(){
//        System.out.println(
//                "beforeGetBookAdvice: книга возвращена.");
//    }
}
