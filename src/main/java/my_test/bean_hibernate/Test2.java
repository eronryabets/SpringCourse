package my_test.bean_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Wallet.class)
                .buildSessionFactory();

        Session session = null;

        try(ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("myBankApplicationContext.xml"))
        {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Person person = context.getBean("personBean", Person.class);
            Wallet wallet = context.getBean("walletBean", Wallet.class);
            person.addWalletToPerson(wallet);
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
        try(ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("myBankApplicationContext.xml"))
        {
            Person person = context.getBean("personBean", Person.class);
            Wallet wallet = context.getBean("walletBean", Wallet.class);
            System.out.println(person);
            System.out.println(wallet);
            person.addWalletToPerson(wallet);
            System.out.println(person.getWallets());
        }
        //=============================================

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Wallet.class)
                .buildSessionFactory();

        Session session = null;
        try{

            session = factory.getCurrentSession();

            session.beginTransaction();
            //session.save(person);
            //session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            session.close();
            factory.close();
        }

 */