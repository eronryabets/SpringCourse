package hibernate_one_to_one;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory()) {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Detail detail = session.get(Detail.class,1);
            detail.getEmployee().setEmpDetail(null);
            session.delete(detail);

            session.getTransaction().commit();
            System.out.println("Done!");
        }



    }
}


/*
 Session session = factory.getCurrentSession();
            session.beginTransaction();

            Detail detail = session.get(Detail.class,4);
            System.out.println(detail + ";\n" + detail.getEmployee());

            session.getTransaction().commit();
            System.out.println("Done!");
===========
try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory()) {

            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Nikolay","Ivanov","HR",850);
            Detail detail = new Detail("New-York","77885544","nikolay@gmail.com");

            employee.setEmpDetail(detail);
            detail.setEmployee(employee);

            session.beginTransaction();
            session.save(detail);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
 */