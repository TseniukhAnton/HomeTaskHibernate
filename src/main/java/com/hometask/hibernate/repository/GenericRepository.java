package com.hometask.hibernate.repository;

import java.util.List;

public interface GenericRepository<T, ID>{
    T getById(ID id);

    boolean deleteById(ID id);

    List<T> getAll();

    void save(T obj);

    boolean update(T obj);
}
