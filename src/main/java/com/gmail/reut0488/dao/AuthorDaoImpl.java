package com.gmail.reut0488.dao;

import com.gmail.reut0488.exceptions.DaoException;
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
        sessionFactory
                .getCurrentSession()
                .persist(entity);
        return entity;
    }

    @Override
    public Author getById(@NotNull Long id) {
        Session session = sessionFactory.openSession();
        Author author = session.find(Author.class, id);
        if (author == null) {
            throw new DaoException("Entity " + Author.class.getSimpleName() + " with id = " + id + " was not found");
        }
        return author;
    }

    @Override
    public @NotNull List<Author> getAll() {
        Session session = sessionFactory.openSession();
        List<Author> authorList =
                session.createQuery("FROM " + Author.class.getName()).list();
        if (authorList == null || authorList.isEmpty()) {
            throw new DaoException("Entities " + Author.class.getSimpleName() + " were not found");
        }
        return authorList;
    }

    @Override
    @Transactional
    public void delete(@NotNull Long id) {
        Author author = getById(id);
        if (author == null) {
            throw new DaoException("Entity " + Author.class.getSimpleName() + " was not found");
        }
        sessionFactory.getCurrentSession().delete(author);
    }

    @NotNull
    @Override
    @Transactional
    public Author update(@NotNull Author entity) {
        Long id = entity.getId();
        if (getById(id) == null) {
            throw new DaoException("Entity with id = " + id + " were not found for update");
        }
        return (Author) sessionFactory.getCurrentSession().merge(entity);
    }
}
