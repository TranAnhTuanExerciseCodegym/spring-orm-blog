package com.codegym.repository.impl;

import com.codegym.model.Blogged;
import com.codegym.repository.BloggedRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
public class BloggedRepositoryImpl implements BloggedRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Blogged> findAll() {
        TypedQuery<Blogged> query = em.createQuery("select c from Blogged c", Blogged.class);
        return query.getResultList();
    }

    @Override
    public Blogged findById(Integer id) {
        TypedQuery<Blogged> query = em.createQuery("select  c from Blogged c where c.id=:id", Blogged.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException  e) {
            return null;
        }
    }

    @Override
    public void save(Blogged model) {
        if (model.getId() != null) {
            em.merge(model);
        } else {
            em.persist(model);
        }
    }

    @Override
    public void remove(Integer id) {
        Blogged blogged = findById(id);
        if (blogged != null) {
            em.remove(blogged);
        }
    }
}
