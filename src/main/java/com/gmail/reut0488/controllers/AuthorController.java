package com.gmail.reut0488.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.gmail.reut0488.dao.IDao;
import com.gmail.reut0488.model.Author;
import com.gmail.reut0488.transfer.IFullDetails;
import com.gmail.reut0488.transfer.INewable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private IDao<Author> authorDaoImpl;

    @JsonView(IFullDetails.class)
    @GetMapping(path = "author/get/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorDaoImpl.getById(id);
    }

    @JsonView(IFullDetails.class)
    @GetMapping(path = "author/get")
    public List<Author> getAllAuthors() {
        return authorDaoImpl.getAll();
    }

    @JsonView(IFullDetails.class)
    @PostMapping(path = "author/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Author saveAuthor(@Validated(INewable.class) @RequestBody Author author) {
        return authorDaoImpl.save(author);
    }

}
