package com.gmail.reut0488.dao;

import com.gmail.reut0488.entities.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorDaoImpl implements IDao<Author> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Author save(Author entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Author author = (Author) session.save(entity);
        session.getTransaction().commit();
        session.close();
        return author;
    }
}
