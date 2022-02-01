package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("Methods main starts");
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(MyConfig.class)) {

            UniLibrary library = context.getBean("uniLibrary", UniLibrary.class);
            String bookName = library.returnBook();
            System.out.println("В библиотеку вернули книгу " + bookName);

        }
        System.out.println("Methods main ends");

    }
}
