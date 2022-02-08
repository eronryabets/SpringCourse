package my_test.bean_created;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;



@Component("personBean")
@Scope("singleton")
public class Person {

    private int id;
    @Value("${person.name}")
    private String name;
    @Value("${person.surname}")
    private String surname;
    private Pet pet;

    @Autowired
    public Person(@Qualifier("catBean") Pet pet) {
        this.pet = pet;
    }

    public Person() {
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

    public Pet getPet() {
        return pet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Autowired
    public void setPet(@Qualifier("catBean") Pet pet) {
        this.pet = pet;
    }

    public void sayHello(){
        System.out.println(this.name + " Hello!");
    }

    @PostConstruct
    private void init(){
        System.out.println("Class Person: init method");
    }
    @PreDestroy
    private void destroy(){
        System.out.println("Class Person: destroy method");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pet=" + pet +
                '}';
    }
}
