package me.siyoon.jpatest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
    Long id;

    String name;

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    Set<Member> members;
}
