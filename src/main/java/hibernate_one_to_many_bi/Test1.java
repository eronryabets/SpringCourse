package hibernate_one_to_many_bi;


import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
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

            System.out.println("Get department");
            Department department = session.get(Department.class, 4);
            System.out.println("Show department");
            System.out.println(department);
            System.out.println("Подгрузим наших работников");
            department.getEmps().get(0);
            session.getTransaction().commit();
            System.out.println("Show employees of the department");
            System.out.println(department.getEmps());
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }



    }
}

/*
System.out.println("Get department");
            Department department = session.get(Department.class, 4);
            System.out.println("Show department");
            System.out.println(department);
            System.out.println("Show employees of the department");
            System.out.println(department.getEmps());
 */

/*
            Department dep = new Department("IT", 300,1200);
            Employee emp1 = new Employee("Zaur", "Tregulov",800);
            Employee emp2 = new Employee("Elena", "Smirnova",100);
            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);
            session.save(dep);
 */

/*
Department dep = new Department("Sales", 1500,800);
            Employee emp1 = new Employee("Zaur", "Tregulov",800);
            Employee emp2 = new Employee("Elena", "Smirnova",1500);
            Employee emp3 = new Employee("Anton", "Sidorov",1200);
            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);
            dep.addEmployeeToDepartment(emp3);
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