package com.gmail.reut0488.dao;

import com.gmail.reut0488.model.IEntity;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.util.List;


public interface IDao<T extends IEntity> {
    T save(@NotNull T entity);
    @Nullable
    T getById(@NotNull Long id);
    @NotNull List<T> getAll();
}
