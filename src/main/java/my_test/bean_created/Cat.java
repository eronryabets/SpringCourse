package my_test.bean_created;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="person_pet")
@Component("catBean")
@Scope("singleton")
public class Cat implements Pet {

    @Value("${pet.name}")
    private String name;

    @Override
    public void voice() {
        System.out.println("Meow-meow");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
