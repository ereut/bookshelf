package com.gmail.reut0488.dao;

import com.gmail.reut0488.model.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

@Component
@Transactional
public class BookDaoImpl implements IDao<Book> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Book save(@NotNull Book entity) {
        sessionFactory
                .getCurrentSession()
                .save(entity);
        return entity;
    }

    @Override
    public Book getById(@NotNull Long id) {
        return sessionFactory
                .getCurrentSession()
                .find(Book.class, id);
    }

    @Override
    public @NotNull List<Book> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM " + Book.class.getName()).list();
    }

}
