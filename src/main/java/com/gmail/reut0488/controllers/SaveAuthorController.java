package com.gmail.reut0488.controllers;

import com.gmail.reut0488.model.Author;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class SaveAuthorController extends AbstractAuthorController {

    @RequestMapping(path = "save/author", method = RequestMethod.POST)
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
