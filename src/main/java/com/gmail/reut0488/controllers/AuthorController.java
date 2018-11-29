package com.gmail.reut0488.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.gmail.reut0488.dao.IDao;
import com.gmail.reut0488.model.Author;
import com.gmail.reut0488.transfer.IFullDetails;
import com.gmail.reut0488.transfer.INewable;
import com.gmail.reut0488.transfer.IUpdateable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private IDao<Author> authorDaoImpl;

    @JsonView(IFullDetails.class)
    @GetMapping(path = "author/get/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorDaoImpl.getById(id));
    }

    @JsonView(IFullDetails.class)
    @GetMapping(path = "author/get")
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(authorDaoImpl.getAll());
    }

    @JsonView(IFullDetails.class)
    @PostMapping(path = "author/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> saveAuthor(@Validated(INewable.class) @RequestBody Author author) {
        return ResponseEntity.ok(authorDaoImpl.save(author));
    }

    @DeleteMapping(path = "author/delete/{id}")
    public ResponseEntity deleteAuthor(@PathVariable Long id) {
        authorDaoImpl.delete(id);
        return ResponseEntity.ok().build();
    }

    @JsonView(IFullDetails.class)
    @PutMapping(path = "author/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> updateAuthor(@Validated(IUpdateable.class) @RequestBody Author author) {
        return ResponseEntity.ok(authorDaoImpl.update(author));
    }
}
