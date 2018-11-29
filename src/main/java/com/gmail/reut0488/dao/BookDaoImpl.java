package com.gmail.reut0488.dao;

import com.gmail.reut0488.exceptions.DaoException;
import com.gmail.reut0488.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

@Component
public class BookDaoImpl implements IDao<Book> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Book save(@NotNull Book entity) {
        sessionFactory
                .getCurrentSession()
                .persist(entity);
        return entity;
    }

    @Override
    public Book getById(@NotNull Long id) {
        Session session = sessionFactory.openSession();
        Book book = session.find(Book.class, id);
        session.close();
        if (book == null) {
            throw new DaoException("Entity " + Book.class.getSimpleName() + " with id = " + id + " was not found");
        }
        return book;
    }

    @Override
    public @NotNull List<Book> getAll() {
        Session session = sessionFactory.openSession();
        List<Book> bookList = session.createQuery("FROM " + Book.class.getName()).list();
        session.close();
        if (bookList == null || bookList.isEmpty()) {
            throw new DaoException("Entities " + Book.class.getSimpleName() + " were not found");
        }
        return bookList;
    }

    @Override
    @Transactional
    public void delete(@NotNull Long id) {
        Book book = getById(id);
        if (book == null) {
            throw new DaoException("Entity " + Book.class.getSimpleName() + " with id = " + id + " was not found");
        }
        sessionFactory.getCurrentSession().delete(book);
    }

    @NotNull
    @Override
    @Transactional
    public Book update(@NotNull Book entity) {
        Long id = entity.getId();
        Book book = getById(id);
        if (book == null) {
            throw new DaoException("Entity " + Book.class.getSimpleName() + " with id = " + id + " was not found");
        }
        return (Book) sessionFactory.getCurrentSession().merge(entity);
    }
}
