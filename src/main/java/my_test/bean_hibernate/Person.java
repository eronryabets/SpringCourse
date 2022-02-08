package my_test.bean_hibernate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "person")
@Component("personBean")
@Scope("singleton")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Value("${person.name}")
    private String name;

    @Column(name = "surname")
    @Value("${person.surname}")
    private String surname;

    @Column(name = "age")
    @Value("${person.age}")
    private int age;

    @Column(name = "salary")
    @Value("${person.salary}")
    private int salary;

    @Column(name = "status")
    @Value("${person.status}")
    private Status status;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "person",
            fetch = FetchType.LAZY)
    private List<Wallet> wallets;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    public void setWallets(List<Wallet> wallets) {
        this.wallets = wallets;
    }

    public void addWalletToPerson(Wallet wallet){
        if(wallets == null){
            wallets = new ArrayList<>();
        }
        wallets.add(wallet);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }
}
