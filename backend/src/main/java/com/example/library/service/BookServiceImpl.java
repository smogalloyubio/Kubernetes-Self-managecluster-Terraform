package com.example.library.service;

import com.example.library.exception.ResourceNotFoundException;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + id));
    }

    @Override
    public Book saveBook(Book book) {
        if (bookRepository.findByIsbn(book.getIsbn()).isPresent()) {
            throw new RuntimeException("ISBN already exists: " + book.getIsbn());
        }
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book bookDetails) {
        Book book = getBookById(id);
        if (!book.getIsbn().equals(bookDetails.getIsbn()) &&
                bookRepository.findByIsbn(bookDetails.getIsbn()).isPresent()) {
            throw new RuntimeException("ISBN already exists: " + bookDetails.getIsbn());
        }
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setIsbn(bookDetails.getIsbn());
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = getBookById(id);
        bookRepository.delete(book);
    }

    @Override
    public List<Book> searchBooks(String keyword) {
        if (keyword != null && !keyword.trim().isEmpty()) {
            return bookRepository.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(keyword, keyword);
        }
        return bookRepository.findAll();
    }

    @Override
    public Book borrowBook(Long id, String username) {
        Book book = getBookById(id);
        if (book.isAvailable()) {
            book.setAvailable(false);
            book.setBorrowedBy(username);
            return bookRepository.save(book);
        }
        throw new RuntimeException("Book is already borrowed");
    }

    @Override
    public Book returnBook(Long id) {
        Book book = getBookById(id);
        book.setAvailable(true);
        book.setBorrowedBy(null);
        return bookRepository.save(book);
    }
}
