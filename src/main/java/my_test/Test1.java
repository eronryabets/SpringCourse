package my_test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        try(ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("myTestApplicationContext.xml")
                ){
            Person person = context.getBean("personBean", Person.class);
            System.out.println(person);
            System.out.println(person.getPet());
        }
    }
}
