package me.siyoon.graphql.baeldungexample.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import me.siyoon.graphql.baeldungexample.domain.Author;
import me.siyoon.graphql.baeldungexample.dto.PostResponse;
import me.siyoon.graphql.baeldungexample.repository.AuthorRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostResolver implements GraphQLResolver<PostResponse> {
    private final AuthorRepository authorRepository;

    public Author getAuthor(PostResponse postResponse) {
        System.out.println("getAuthor 실행!");
        return authorRepository.findById(postResponse.getAuthor().getId()).orElseThrow(NullPointerException::new);
    }
}
