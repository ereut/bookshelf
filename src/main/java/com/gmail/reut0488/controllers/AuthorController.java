package com.gmail.reut0488.controllers;

import com.gmail.reut0488.dao.IDao;
import com.gmail.reut0488.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class AuthorController {

    @Value("${bookshelf.author.birthdayPattern}")
    protected String authorBirthDayPattern;

    @Autowired
    protected IDao<Author> authorDaoImpl;

    @RequestMapping(path = "author/get/{id}", method = RequestMethod.GET)
    public Author getAuthorById(@PathVariable Long id) {
        return authorDaoImpl.getById(id);
    }

    @RequestMapping(path = "author/get")
    public List<Author> getAllAuthors() {
        return authorDaoImpl.getAll();
    }

    @RequestMapping(path = "author/save", method = RequestMethod.POST)
    public Author saveAuthor(@RequestParam(value = "firstName") String firstName,
                             @RequestParam(value = "lastName") String lastName,
                             @RequestParam(value = "birthDate") String birthDate) {
        Author author =
                new Author(
                        firstName,
                        lastName,
                        Date.valueOf(LocalDate.parse(
                                birthDate,
                                DateTimeFormatter.ofPattern(authorBirthDayPattern))
                        )
                );
        authorDaoImpl.save(author);
        return author;
    }

}
