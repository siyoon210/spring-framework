package project.prototype.pat.PatProtoType.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "book_content")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(length = 100, nullable = false)
    private String name;

    @Column
    private Long superiorId;

    @Column(nullable = false)
    private int orderBy;
}
