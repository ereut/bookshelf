package com.gmail.reut0488.dao;

import com.gmail.reut0488.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

@Component
public class AuthorDaoImpl implements IDao<Author> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Author save(@NotNull Author entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    @Override
    public Author getById(@NotNull Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Author author = session.find(Author.class, id);
        session.getTransaction().commit();
        session.close();
        return author;
    }

    @Override
    public @NotNull List<Author> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        List<Author> authorsList = session.createNativeQuery("SELECT * FROM authors", Author.class).getResultList();
        List<Author> authorsList = (List<Author>) session.createQuery("FROM " + Author.class.getName()).list();
        session.getTransaction().commit();
        session.close();
        return authorsList;
    }

}
