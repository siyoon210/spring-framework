package me.siyoon.graphql.baeldungexample.repository;


import me.siyoon.graphql.baeldungexample.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
