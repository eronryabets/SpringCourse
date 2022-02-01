package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("Lord of the Rings")
    private String name;

    @Value("J.R.Tolkien")
    private String author;

    @Value("1967")
    private int yearOfPublication;


    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
}
