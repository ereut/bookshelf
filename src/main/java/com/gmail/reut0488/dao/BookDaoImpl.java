package com.gmail.reut0488.dao;

import com.gmail.reut0488.model.Book;

import javax.validation.constraints.NotNull;
import java.util.List;

public class BookDaoImpl implements IDao<Book> {

    @Override
    public Book save(@NotNull Book entity) {
        return null;
    }

    @Override
    public Book getById(@NotNull Long id) {
        return null;
    }

    @Override
    public @NotNull List<Book> getAll() {
        return null;
    }
}
