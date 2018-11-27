package com.gmail.reut0488.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.gmail.reut0488.dao.IDao;
import com.gmail.reut0488.model.Book;
import com.gmail.reut0488.transfer.IFullDetails;
import com.gmail.reut0488.transfer.INewable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class BookController {

    @Autowired
    private IDao<Book> bookDaoImpl;

    @JsonView(IFullDetails.class)
    @PostMapping(path = "book/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book save(@Validated(INewable.class) @RequestBody Book book) {
        return bookDaoImpl.save(book);
    }

    @JsonView(IFullDetails.class)
    @GetMapping(path = "book/get/{id}")
    public Book getById(@PathVariable Long id) {
        return bookDaoImpl.getById(id);
    }

    @JsonView(IFullDetails.class)
    @GetMapping(path = "book/get")
    public List<Book> getAll() {
        return bookDaoImpl.getAll();
    }

}
