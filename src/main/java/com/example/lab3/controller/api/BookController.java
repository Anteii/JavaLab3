package com.example.lab3.controller.api;

import com.example.lab3.dto.BookDto;
import com.example.lab3.model.Book;
import com.example.lab3.repository.BookRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/books", produces = {"application/json", "application/xml"})
public class BookController {

    final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Integer id){
        return bookRepository.findById(id).orElseThrow();
    }

    @GetMapping("/all")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    @PostMapping("/update")
    public void update(@RequestBody Book book){
        bookRepository.saveAndFlush(book);
    }

    @PostMapping("/create")
    public Book create(@RequestBody BookDto bookDto){
        Book book = new Book(bookDto.getTitle(), bookDto.getAuthorName(), bookDto.getGenre(), bookDto.getPrice());
        bookRepository.saveAndFlush(book);
        return book;
    }

    @DeleteMapping("/delete/{id}")
    public Book delete(@PathVariable Integer id){
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);
        return book;
    }

}
