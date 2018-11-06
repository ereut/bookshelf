package com.gmail.reut0488.dao;

import com.gmail.reut0488.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class AuthorDaoImpl implements IDao<Author> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Author save(@NotNull Author entity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
        return entity;
    }
}
