package my_test.bean_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

//получение Person из БД, повышение ЗП, добавление одного нового кошелька
public class Test4 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Wallet.class)
                .buildSessionFactory();

        Session session = null;

        try(ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext(
                            "myBankApplicationContext.xml"))
        {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class, 2);
            Wallet wallet = context.getBean("walletBean", Wallet.class);
            person.addWalletToPerson(wallet);
            person.setSalary(1300);
            person.setStatus(Status.PREMIUM);

            session.save(person);
            session.getTransaction().commit();
            System.out.println("Done!");
        }

        finally {
            session.close();
            factory.close();
        }
    }
}

/*
Person person = session.get(Person.class,1);
            Wallet wallet = context.getBean("walletBean", Wallet.class);
            person.addWalletToPerson(wallet);
            person.setSalary(900);
            person.setStatus(Status.MEDIUM);
 */