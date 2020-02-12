package atdd.station.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Station {
    @Id
    private Long id;

    private String name;
}
