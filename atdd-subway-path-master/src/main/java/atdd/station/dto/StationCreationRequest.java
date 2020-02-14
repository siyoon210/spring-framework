package atdd.station.dto;

import atdd.station.domain.Station;
import lombok.Builder;

public class StationCreationRequest {
    private String name;

    @Builder
    public StationCreationRequest(String name) {
        this.name = name;
    }

    public Station toEntity() {
        return Station.builder()
                .name(this.name)
                .build();
    }
}
