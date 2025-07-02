package com.dn.javaFSE.LibraryManagement.service;

import com.dn.javaFSE.LibraryManagement.entity.Book;
import com.dn.javaFSE.LibraryManagement.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
        log.info("Book added successfully");
    }

    public void deleteBook(int bookId) {
        bookRepository.deleteById(bookId);
        log.info("Book deleted successfully");
    }

    public Book updateBook(Book update) {
        Book oldBook = bookRepository.findById(update.getId()).orElseThrow(() -> new RuntimeException("Invalid id"));
        oldBook.setAuthor(update.getAuthor());
        oldBook.setPrice(update.getPrice());
        oldBook.setName(update.getName());
        return bookRepository.save(oldBook);
    }

    public Book getBookById(int bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if (bookOptional.isEmpty()) throw new RuntimeException("Book not found");
        return bookOptional.get();
    }

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
