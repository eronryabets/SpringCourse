package my_test.bean_hibernate;


import org.springframework.context.support.ClassPathXmlApplicationContext;
//создание бинов
public class Test1 {
    public static void main(String[] args) {
        try(ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("myBankApplicationContext.xml"))
        {
            Person person = context.getBean("personBean", Person.class);
            Wallet wallet = context.getBean("walletBean", Wallet.class);
            System.out.println(person);
            person.addWalletToPerson(wallet);
            System.out.println(person.getWallets());
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