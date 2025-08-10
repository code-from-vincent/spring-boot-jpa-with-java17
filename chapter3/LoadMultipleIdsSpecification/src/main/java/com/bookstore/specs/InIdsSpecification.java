package com.bookstore.specs;

import com.bookstore.entity.Book;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class InIdsSpecification implements Specification<Book> {
    private final List<Long> ids;

    public InIdsSpecification(List<Long> ids) {
        this.ids = ids;
    }

    @Override
    public Predicate toPredicate(Root<Book> root,
                                 CriteriaQuery<?> cquery, CriteriaBuilder cbuilder) {
        return root.in(ids);

        // or
        // Expression<String> expression = root.get("id");
        // return expression.in(ids);
    }
}