package examples.boot.sunnyboard.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
Member <----> Board
     1      * (member_id : fk)
     @ManyToOne    @JoinColumn(name="member_id")
*/
@Entity
@Table(name = "sunny_board")
@Setter
@Getter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    // 255 not null
    @Column(nullable = false, length = 255)
    private String title;
    // text not null
    @Lob
    private String content;
    private int readCount;
    // now()
    @Column
    @CreationTimestamp
    private LocalDateTime regDate;

    @Column
    @UpdateTimestamp
    private LocalDateTime updateDate;
}
