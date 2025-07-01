package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public void addBook(String bookName) {
        System.out.println(bookName + " added successfully!");
    }
}
