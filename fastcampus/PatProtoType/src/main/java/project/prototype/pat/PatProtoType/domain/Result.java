package project.prototype.pat.PatProtoType.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "result")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_record_id", nullable = false)
    private QuizRecord quizRecord;

    @ManyToOne
    @JoinColumn(name = "Question", nullable = false)
    private Question question;

    @Column(nullable = false)
    private Boolean correct;


}
