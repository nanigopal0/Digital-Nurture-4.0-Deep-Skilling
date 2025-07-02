package com.dn.javaFSE.LibraryManagement.repository;

import com.dn.javaFSE.LibraryManagement.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {
}
