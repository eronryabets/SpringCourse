package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(MyConfig.class)
        ) {
            UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
            Book book = context.getBean("book", Book.class);
            uniLibrary.getBook(book);
            uniLibrary.returnBook();
//            SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
//            schoolLibrary.getBook();


        }

    }
}
