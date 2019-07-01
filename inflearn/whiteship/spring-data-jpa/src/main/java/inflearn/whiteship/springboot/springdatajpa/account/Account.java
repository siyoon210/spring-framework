package inflearn.whiteship.springboot.springdatajpa.account;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Account {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
}
