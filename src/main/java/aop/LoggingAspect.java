package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Order(10)
public class LoggingAspect {


    @Before("aop.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = "
                + methodSignature);
        System.out.println("methodSignature.getMethod() = "
                + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = "
                + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = "
                + methodSignature.getName());

        if (methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();
            Arrays.stream(arguments).forEach(obj -> {
                if (obj instanceof Book) {
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге: название - " +
                            myBook.getName() + ", автор - " + myBook.getAuthor() +
                            ", год изания - " + myBook.getYearOfPublication());
                }
                else if(obj instanceof String){
                    System.out.println("Книгу в библиотеку добавляет " + obj);
                }
            });
        }
        System.out.println("beforeGetBookAdvice: логирование " +
                "попытки получить книгу/журнал.");
        System.out.println("-------------------------------------");
    }

//    @Pointcut("execution(* aop.UniLibrary.*(..))")
//    public void allMethodFromUniLibrary(){}
//
//    @Pointcut("execution(public void aop.UniLibrary.returnMagazine(..))")
//    public void returnMagazineFromUniLibrary(){}
//
//    @Pointcut("allMethodFromUniLibrary() && !returnMagazineFromUniLibrary()")
//    public void allMethodExceptReturnMagazineFromUniLibrary(){}
//
//    @Before("allMethodExceptReturnMagazineFromUniLibrary()")
//    public void BeforeMethodExceptReturnMagazineAdvice(){
//        System.out.println("BeforeMethodExceptReturnMagazineAdvice: Log#10 ");
//    }


//    @Pointcut("execution(* aop.UniLibrary.get*())")
//    public void allGetMethodFromUniLibrary(){}
//
//    @Pointcut("execution(* aop.UniLibrary.return*())")
//    public void allReturnMethodFromUniLibrary(){}
//
//    @Pointcut ("allGetMethodFromUniLibrary() || allReturnMethodFromUniLibrary()")
//    private void allGetAndReturnMethodFromUniLibrary(){}
//
//
//    @Before("allGetMethodFromUniLibrary()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetLoggingAdvice: writing Log #1");
//    }
//
//    @Before("allReturnMethodFromUniLibrary()")
//    public void beforeReturnLoggingAdvice(){
//        System.out.println("beforeGetLoggingAdvice: writing Log #2");
//    }
//
//    @Before("allGetMethodFromUniLibrary() || allReturnMethodFromUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice(){
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log #3");
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
