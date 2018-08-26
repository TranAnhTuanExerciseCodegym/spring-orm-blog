package com.codegym.service;

import com.codegym.model.Blogged;

import java.util.List;

public interface BloggedService {
    List<Blogged> findAll();

    Blogged findById(Integer id);

    void save(Blogged blogged);

    void remove(Integer id);
}
