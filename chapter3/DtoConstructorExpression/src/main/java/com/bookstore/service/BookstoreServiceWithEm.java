package com.bookstore.service;

import com.bookstore.dto.AuthorDto;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

@Service
public class BookstoreServiceWithEm {
    @PersistenceContext
    private EntityManager entityManager;

    public List<AuthorDto> getResultList() {
        Query query = entityManager.createQuery(
                "SELECT new com.bookstore.dto.AuthorDto(a.name, a.age) " +
                        "FROM Author a", AuthorDto.class);
        List<AuthorDto> authors = query.getResultList();

        return authors;
    }
}