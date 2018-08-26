package com.codegym.service.impl;

import com.codegym.model.Blogged;
import com.codegym.repository.BloggedRepository;
import com.codegym.service.BloggedService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BloggedServiceImpl implements BloggedService {
    @Autowired
    private BloggedRepository bloggedRepository;

    @Override
    public List<Blogged> findAll() {
        return bloggedRepository.findAll();
    }

    @Override
    public Blogged findById(Integer id) {
        return bloggedRepository.findById(id);
    }

    @Override
    public void save(Blogged blogged) {
        bloggedRepository.save(blogged);
    }

    @Override
    public void remove(Integer id) {
        bloggedRepository.remove(id);
    }
}
