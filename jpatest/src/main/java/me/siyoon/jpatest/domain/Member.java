package me.siyoon.jpatest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    Long id;

    String name;

    @ManyToOne
    @JoinColumn(name = "team_id")
    Team team;
}
