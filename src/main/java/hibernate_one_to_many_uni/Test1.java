package hibernate_one_to_many_uni;



import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try  {

            session = factory.getCurrentSession();
            session.beginTransaction();

            Department department = session.get(Department.class,3);
            session.delete(department);


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
            Department dep = new Department("HR", 500,1500);
            Employee emp1 = new Employee("Oleg", "Ivanov",800);
            Employee emp2 = new Employee("Andrey", "Sidorov",100);
            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);
            session.save(dep);
 */

/*
            List<Employee> emps = session.createQuery("from Employee").getResultList();
            emps.forEach(System.out::println);
            Department dep = session.get(Department.class,1);
            List<Employee> emps = dep.getEmps();
            emps.forEach(System.out::println);
 */

/*
            Department department = session.get(Department.class,1);
            System.out.println(department);
            System.out.println(department.getEmps());
 */