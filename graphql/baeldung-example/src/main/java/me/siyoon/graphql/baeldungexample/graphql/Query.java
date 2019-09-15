package me.siyoon.graphql.baeldungexample.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import me.siyoon.graphql.baeldungexample.domain.Post;
import me.siyoon.graphql.baeldungexample.dto.PostResponse;
import me.siyoon.graphql.baeldungexample.repository.PostRepository;

import java.util.List;

public class Query implements GraphQLQueryResolver {
    private PostRepository postRepository;

    public List<PostResponse> recentPosts(int count, int offset) {
        final List<Post> all = postRepository.findAll();
        return PostResponse.from(all);
    }
}
