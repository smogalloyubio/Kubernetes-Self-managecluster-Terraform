package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookWebController {

    private final BookService bookService;

    @Autowired
    public BookWebController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String listBooks(Model model, @RequestParam(required = false) String keyword) {
        if (keyword != null) {
            model.addAttribute("books", bookService.searchBooks(keyword));
            model.addAttribute("keyword", keyword);
        } else {
            model.addAttribute("books", bookService.getAllBooks());
        }
        return "book-list";
    }

    @GetMapping("/books/add")
    public String showAddForm(Book book) {
        return "book-add";
    }

    @PostMapping("/books/add")
    public String addBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book-add";
        }
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book-update";
    }

    @PostMapping("/books/update/{id}")
    public String updateBook(@PathVariable("id") Long id, @Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            book.setId(id);
            return "book-update";
        }
        bookService.updateBook(id, book);
        return "redirect:/books";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/books/borrow/{id}")
    public String borrowBook(@PathVariable("id") Long id, Authentication authentication) {
        bookService.borrowBook(id, authentication.getName());
        return "redirect:/books";
    }

    @GetMapping("/books/return/{id}")
    public String returnBook(@PathVariable("id") Long id) {
        bookService.returnBook(id);
        return "redirect:/books";
    }
}
