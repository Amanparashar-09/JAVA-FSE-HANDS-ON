package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService setterService = context.getBean("bookServiceSetter", BookService.class);
        System.out.println("--- Setter Injection ---");
        setterService.displayBooks();

        BookService constructorService = context.getBean("bookServiceConstructor", BookService.class);
        System.out.println("--- Constructor Injection ---");
        constructorService.displayBooks();

        ((ClassPathXmlApplicationContext) context).close();
    }
}
