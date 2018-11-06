package com.gmail.reut0488.dao;

import com.gmail.reut0488.model.IEntity;

import javax.validation.constraints.NotNull;

public interface IDao<T extends IEntity> {
    T save(@NotNull T entity);
}
