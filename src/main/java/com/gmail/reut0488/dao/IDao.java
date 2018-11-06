package com.gmail.reut0488.dao;

import com.gmail.reut0488.entities.AbstractEntity;

public interface IDao<T extends AbstractEntity> {
    T save(T entity);
}
