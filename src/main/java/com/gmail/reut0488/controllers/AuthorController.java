package com.gmail.reut0488.controllers;

import com.gmail.reut0488.dao.IDao;
import com.gmail.reut0488.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    protected IDao<Author> authorDaoImpl;

    @RequestMapping(path = "author/get/{id}", method = RequestMethod.GET)
    public Author getAuthorById(@PathVariable Long id) {
        return authorDaoImpl.getById(id);
    }

    @RequestMapping(path = "author/get", method = RequestMethod.GET)
    public List<Author> getAllAuthors() {
        return authorDaoImpl.getAll();
    }

    @RequestMapping(path = "author/save", method = RequestMethod.POST)
    public Author saveAuthor(@RequestParam(value = "firstName") String firstName,
                             @RequestParam(value = "lastName") String lastName) {
        return authorDaoImpl.save(new Author(firstName, lastName));
    }

}
