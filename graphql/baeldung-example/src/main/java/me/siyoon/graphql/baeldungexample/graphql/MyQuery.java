package me.siyoon.graphql.baeldungexample.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import me.siyoon.graphql.baeldungexample.domain.Post;
import me.siyoon.graphql.baeldungexample.dto.PostResponse;
import me.siyoon.graphql.baeldungexample.repository.PostRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MyQuery implements GraphQLQueryResolver {
    private final PostRepository postRepository;

    public List<PostResponse> getRecentPosts(int count, int offset) {
        final List<Post> all = postRepository.findAll();
        return PostResponse.from(all);
    }
}
