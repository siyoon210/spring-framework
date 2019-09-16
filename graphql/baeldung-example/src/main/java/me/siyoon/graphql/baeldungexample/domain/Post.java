package me.siyoon.graphql.baeldungexample.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String text;
    private String category;

    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;
}
