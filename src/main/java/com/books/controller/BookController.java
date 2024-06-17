package com.books.controller;

import com.books.exception.BookNotFoundException;
import com.books.model.Book;
import com.books.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Books", description = "Operations related to books")
@CrossOrigin(origins = "${baseUrl}")
@RequestMapping("/books")
@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Operation(summary = "Get all books")
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Operation(summary = "Add a new book")
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @Operation(summary = "Get book by id")
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Não foi possível encontrar livro"));
    }

    @Operation(summary = "Edit book")
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Não foi possível editar, livro não encontrado."));
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        return bookRepository.save(book);
    }

    @Operation(summary = "Delete book")
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Não foi possível apagar, livro não encontrado."));
        bookRepository.delete(book);
    }
}
