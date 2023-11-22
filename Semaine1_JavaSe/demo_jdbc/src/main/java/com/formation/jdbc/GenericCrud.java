package com.formation.jdbc;

import java.util.List;

public interface GenericCrud<T, ID> {

    List<T> fetchAll();

    T fetchById(ID id);

    boolean delete(ID id);

    T create(T t);

    T update(ID id, T t);
}
