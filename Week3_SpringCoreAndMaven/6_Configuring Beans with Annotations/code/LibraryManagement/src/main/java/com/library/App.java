package com.library;

import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService =(BookService) context.getBean("bookService");
        BookRepository bookRepository =(BookRepository) context.getBean("bookRepository");
        bookService.addBook("Java 21");
        bookRepository.addBook("Spring 6");
    }
}
