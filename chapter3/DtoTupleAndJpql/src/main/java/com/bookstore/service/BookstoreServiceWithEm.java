package com.bookstore.service;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Service
public class BookstoreServiceWithEm {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Tuple> fetchAuthorsWithNativeSQL() {
        // using native SQL
        Query query = entityManager.createNativeQuery(
                "SELECT name, age FROM author", Tuple.class);
        List<Tuple> authors = query.getResultList();

        return authors;
    }

    public List<Tuple> fetchAuthorsWithJPQL() {
        // using JPQL
        TypedQuery<Tuple> query = entityManager.createQuery(
                "SELECT a.name AS name, a.age AS age FROM Author a", Tuple.class);
        List<Tuple> authors = query.getResultList();

        return authors;
    }
}
