# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Overview
This repository contains examples from the book "Spring Boot Persistence Best Practices" organized by chapters. Each chapter demonstrates specific JPA and Hibernate optimization techniques using Spring Boot 3.3.7 with Java 17. Examples are structured as independent Maven projects within chapter directories.

## Development Commands

### Maven Commands (for each example project)
```bash
# Build project
./mvnw clean compile

# Run tests
./mvnw test

# Run Spring Boot application
./mvnw spring-boot:run

# Package application
./mvnw clean package
```

### Database Setup Requirements
Most examples require MySQL database setup:
```sql
create database bookstoredb character set utf8mb4 collate utf8mb4_general_ci;
create user 'bookstore'@'%' identified by 'bookstore';
grant all privileges on bookstoredb.* to 'bookstore'@'%';
flush privileges;
```

Some examples also use PostgreSQL (`bookstoredb`) and SQL Server (`bookstoredb`).

## Project Architecture

### Structure Pattern
Each example follows consistent structure:
- `src/main/java/com/bookstore/` - Main package
  - `MainApplication.java` - Spring Boot entry point with ApplicationRunner
  - `entity/` - JPA entities (Author, Book, etc.)
  - `repository/` - Spring Data JPA repositories
  - `service/` - Business logic services
- `src/main/resources/`
  - `application.properties` - Database and JPA configuration
  - `schema-{db}.sql` - DDL scripts for table creation
  - `data-{db}.sql` - Optional test data

### Key Configuration
- Java 17 target
- Spring Boot 3.3.7
- Hibernate with `ddl-auto=validate` (DDL managed by schema files)
- MySQL 8 dialect by default
- `open-in-view=false` for performance
- SQL logging enabled with `show-sql=true`

### Example Categories by Chapter
- Chapter 1: Association mappings (@OneToMany, @ManyToOne, etc.)
- Chapter 2: Entity design patterns
- Chapter 3: Fetching strategies and projections  
- Chapter 4: Batch operations
- Chapter 5: Collections handling
- Chapter 6-16: Advanced topics (transactions, identifiers, pagination, etc.)

## Running Examples
1. Navigate to specific example directory (e.g., `chapter1/CascadeChildRemoval/`)
2. Ensure required database is set up
3. Run `./mvnw spring-boot:run`
4. Check console output for SQL queries and results