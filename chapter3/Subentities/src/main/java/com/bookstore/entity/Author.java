package com.bookstore.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Lob;

//@Entity
public class Author {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Lob
    private byte[] avatar;

    private int age;
    private String name;
    private String genre;

    // getters and setters omitted for brevity
}
