package com.bookstore.service;

import org.hibernate.Session;
import org.hibernate.jpa.QueryHints;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Service
public class DummyService {
    @PersistenceContext
    private final EntityManager entityManager;

    public DummyService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void setDefaultReadOnly() {
        try (Session session = entityManager.unwrap(Session.class)) {
            session.setDefaultReadOnly(true);
        }
        //...
    }

    public void JpaHint() {
        List<Foo> foo = entityManager.createQuery("select f from Foo f", Foo.class)
                .setHint(QueryHints.HINT_READONLY, true)
                .getResultList();
    }

    private class Foo {
    }
}
