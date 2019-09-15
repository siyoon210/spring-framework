package me.siyoon.graphql.baeldungexample.dto;

import lombok.*;
import me.siyoon.graphql.baeldungexample.domain.Post;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
public class PostResponse {
    private String id;
    private String title;
    private String category;
    private String authorId;

    public static List<PostResponse> from(Collection<Post> entities) {
        return entities.stream().map(PostResponse::from).collect(Collectors.toList());
    }

    private static PostResponse from(Post entity) {
        return PostResponse.builder()
                .id(String.valueOf(entity.getId()))
                .title(entity.getTitle())
                .category(entity.getCategory())
                .authorId(String.valueOf(entity.getAuthor().getId()))
                .build();
    }
}
