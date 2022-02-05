package hibernate_one_to_many_bi.entity;

public class MyTest {
    public static void main(String[] args) {

    }
}
/*
//протестить ошибки с закрытием потока у трай ресурсис и трай файнали
//для теста ошибки нужно любую @Column(name="id_НАЗВАТЬ НЕ ПРАВИЛЬНО")

SessionFactory и Session объекты не могут работать с «попробовать с ресурсом»,
потому что два класса не реализуют AutoCloseable интерфейс !
=======================================================================
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory()) {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Department dep = new Department("IT", 300,1200);
            Employee emp1 = new Employee("Zaur", "Tregulov",800);
            Employee emp2 = new Employee("Elena", "Smirnova",100);
            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);

            session.save(dep);

            session.getTransaction().commit();
            System.out.println("Done!");
        }

======================================================

SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try  {

            session = factory.getCurrentSession();
            session.beginTransaction();

            Department dep = new Department("IT", 300,1200);
            Employee emp1 = new Employee("Zaur", "Tregulov",800);
            Employee emp2 = new Employee("Elena", "Smirnova",100);
            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);

            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            session.close();
            factory.close();
        }
 */