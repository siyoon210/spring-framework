package project.prototype.pat.PatProtoType.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "passage")
@Data
@NoArgsConstructor
@AllArgsConstructor
//TODO: Passage말고 다른 이름은 어떨까? 좀 구려보임
public class Passage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "passages")
    private Set<Question> questions;

    @Column(length = 100, nullable = false)
    private String type;

    //TODO: 현재는 passage type이 텍스트인 경우만 고려 했지만, 그림이나 표인경우는 어떤식으로 구현해야 하는지 필요함
    @Column(nullable = false)
    private String content;
}
