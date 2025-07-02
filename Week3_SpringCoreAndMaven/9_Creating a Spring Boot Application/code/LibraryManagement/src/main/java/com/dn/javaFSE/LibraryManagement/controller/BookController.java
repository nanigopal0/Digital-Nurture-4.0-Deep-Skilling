package com.dn.javaFSE.LibraryManagement.controller;

import com.dn.javaFSE.LibraryManagement.entity.Book;
import com.dn.javaFSE.LibraryManagement.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("get")
    public ResponseEntity<Book> getBookById(@RequestParam int bookId) {
        try {
            return ResponseEntity.ok(bookService.getBookById(bookId));
        } catch (RuntimeException e) {
            log.error("Error while getting book: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("get-all")
    public ResponseEntity<Iterable<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping("add")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity.ok("Book added successfully");
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteBook(@RequestParam int bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok("Book deleted successfully");
    }

    @PutMapping("update")
    public ResponseEntity<Book> updateBook(@RequestBody Book update) {
        try {
            return ResponseEntity.ok(bookService.updateBook(update));
        } catch (RuntimeException e) {
            log.error("Error while updating book: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
