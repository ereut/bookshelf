package com.gmail.reut0488.controllers;

import com.gmail.reut0488.dao.IDao;
import com.gmail.reut0488.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public abstract class AbstractAuthorController {

    @Value("${bookshelf.author.birthdayPattern}")
    protected String authorBirthDayPattern;

    @Autowired
    protected IDao<Author> authorDaoImpl;

}
