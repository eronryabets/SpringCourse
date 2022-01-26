package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        try(ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("applicationContext.xml"))
        {
//            Pet pet = context.getBean("myPet",Pet.class);
//            Person person = new Person(pet);
//            Pet pet = new Cat();
            Person person = context.getBean("myPerson",Person.class);
            person.callYourPet();
            System.out.println(person.getSurname());
            System.out.println(person.getAge());
        }

    }
}
