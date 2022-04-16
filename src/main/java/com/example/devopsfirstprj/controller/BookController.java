package com.example.devopsfirstprj.controller;


import com.example.devopsfirstprj.exception.ResourceNotFoundException;
import com.example.devopsfirstprj.model.Book;
import com.example.devopsfirstprj.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("BookSale/")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // create book rest api
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // get book by book_id rest api
    @GetMapping("/books/{book_id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer book_id) {
        Book book = bookRepository.findById(book_id)
                .orElseThrow(() -> new ResourceNotFoundException("Book doesn't exist with book id: "+book_id));
        return ResponseEntity.ok(book);
    }

    // update book rest api
    @PutMapping("/books/{book_id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer book_id, @RequestBody Book bookDetails){
        Book book = bookRepository.findById(book_id)
                .orElseThrow(() -> new ResourceNotFoundException("Book doesn't exist with book id: "+book_id));

        book.setName(bookDetails.getName());
        book.setPrice(bookDetails.getPrice());
        book.setAuthor(bookDetails.getAuthor());
        book.setBookPagesNum(bookDetails.getBookPagesNum());
        book.setGenre(bookDetails.getGenre());

        Book updateBook = bookRepository.save(book);
        return ResponseEntity.ok(updateBook);
    }

    // delete book rest api
    @DeleteMapping("/books/{book_id}")
    public ResponseEntity<Map<String, Boolean>> deleteBook(@PathVariable Integer book_id) {
        Book book = bookRepository.findById(book_id)
                .orElseThrow(() -> new ResourceNotFoundException("Book doesn't exist with book id: "+book_id));
        bookRepository.delete(book);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}






















