package com.bookstore.summary;

import com.bookstore.entity.Book;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Subselect(
        "SELECT a.id AS id, a.name AS name, a.genre AS genre FROM Author a")
@Synchronize({"author", "book"})
@Immutable
public class AuthorSummary implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String name;
    private String genre;

    @OneToMany(mappedBy = "author")
    private Set<Book> books = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public Set<Book> getBooks() {
        return books;
    }
}