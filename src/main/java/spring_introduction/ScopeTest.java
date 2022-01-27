package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        try(ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml")) {
            Dog myDog = context.getBean("dog", Dog.class);
            myDog.say();

//            Dog yourDog = context.getBean("dog",Dog.class);
//            System.out.println("Переменные ссылаются на один и тот же обьект? " + myDog.equals(yourDog));

        }

    }
}
