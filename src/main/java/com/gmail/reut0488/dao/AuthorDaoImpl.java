package com.gmail.reut0488.dao;

import com.gmail.reut0488.model.Author;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

@Component
@Transactional
public class AuthorDaoImpl implements IDao<Author> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Author save(@NotNull Author entity) {
        sessionFactory
                .getCurrentSession()
                .save(entity);
        return entity;
    }

    @Override
    public Author getById(@NotNull Long id) {
        return sessionFactory
                .getCurrentSession()
                .find(Author.class, id);
    }

    @Override
    public @NotNull List<Author> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM " + Author.class.getName()).list();
    }

}
