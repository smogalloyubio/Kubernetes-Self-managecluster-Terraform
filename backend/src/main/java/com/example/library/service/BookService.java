package com.example.library.service;

import com.example.library.model.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book saveBook(Book book);
    Book updateBook(Long id, Book bookDetails);
    void deleteBook(Long id);
    List<Book> searchBooks(String keyword);
    Book borrowBook(Long id, String username);
    Book returnBook(Long id);
}
