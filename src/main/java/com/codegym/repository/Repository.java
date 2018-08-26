package com.codegym.repository;


import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    void save(T model);

    T findById(Integer id);

    void remove(Integer id);

}
