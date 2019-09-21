package me.siyoon.graphql.baeldungexample.repository;


import me.siyoon.graphql.baeldungexample.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
