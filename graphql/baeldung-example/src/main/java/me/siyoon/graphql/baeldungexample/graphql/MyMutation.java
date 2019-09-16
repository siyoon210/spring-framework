package me.siyoon.graphql.baeldungexample.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import me.siyoon.graphql.baeldungexample.domain.Author;
import me.siyoon.graphql.baeldungexample.domain.Post;
import me.siyoon.graphql.baeldungexample.dto.PostResponse;
import me.siyoon.graphql.baeldungexample.repository.AuthorRepository;
import me.siyoon.graphql.baeldungexample.repository.PostRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyMutation implements GraphQLMutationResolver {
    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;

    public PostResponse writePost(String title, String text, String category) {
        Post post = new Post();
        post.setTitle(title);
        post.setText(text);
        post.setCategory(category);
        post.setAuthor(authorRepository.getOne(1L));

        final Post save = postRepository.save(post);

        return PostResponse.from(save);
    }
}
