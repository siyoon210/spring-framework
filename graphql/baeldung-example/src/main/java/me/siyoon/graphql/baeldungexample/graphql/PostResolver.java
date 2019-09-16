package me.siyoon.graphql.baeldungexample.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import me.siyoon.graphql.baeldungexample.domain.Author;
import me.siyoon.graphql.baeldungexample.domain.Post;
import me.siyoon.graphql.baeldungexample.repository.AuthorRepository;

@RequiredArgsConstructor
public class PostResolver implements GraphQLResolver<Post> {
    private final AuthorRepository authorRepository;

    public Author getAuthor(Post post) {
        return authorRepository.getOne(post.getAuthor().getId());
    }
}
