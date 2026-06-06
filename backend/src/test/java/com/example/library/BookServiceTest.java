package com.example.library;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    private Book book;

    @BeforeEach
    void setUp() {
        book = Book.builder()
                .id(1L)
                .title("Test Book")
                .author("Test Author")
                .isbn("1234567890")
                .available(true)
                .build();
    }

    @Test
    void testSaveBook() {
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        Book savedBook = bookService.saveBook(new Book());
        assertNotNull(savedBook);
        assertEquals("Test Book", savedBook.getTitle());
    }

    @Test
    void testGetBookById() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        Book foundBook = bookService.getBookById(1L);
        assertEquals("Test Book", foundBook.getTitle());
    }

    @Test
    void testBorrowBook() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        
        Book borrowedBook = bookService.borrowBook(1L, "user1");
        
        assertFalse(borrowedBook.isAvailable());
        assertEquals("user1", borrowedBook.getBorrowedBy());
    }
}
