package my_test.bean_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Wallet.class)
                .buildSessionFactory();

        Session session = null;
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class,1);
            System.out.println(person);
            List<Wallet> wallets = session.createQuery("from Wallet").getResultList();
            wallets.forEach(System.out::println);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }



    }
}
