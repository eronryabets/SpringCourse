package my_test.bean_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
//получение бинов
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

            //Person person = session.get(Person.class,2);
            //System.out.println(person);
            System.out.println("Кошелек :");
            List<Wallet> wallets =
                    session.createQuery("from Wallet where balance > 1000").getResultList();
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
