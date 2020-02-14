package atdd.station.domain;

import atdd.station.dto.StationCreationResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Station {
    @Id
    private Long id;

    private String name;

    @Builder
    public Station(String name) {
        this.name = name;
    }

    public StationCreationResponse toStationCreationResponse() {
        return StationCreationResponse.builder()
                .name(name)
                .build();
    }
}
