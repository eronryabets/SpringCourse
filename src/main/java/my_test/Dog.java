package my_test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("dogBean")
@Scope("prototype")
public class Dog implements Pet {
    @Override
    public void voice() {
        System.out.println("Bow-bow");
    }
}
