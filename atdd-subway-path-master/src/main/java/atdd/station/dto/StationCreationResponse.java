package atdd.station.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StationCreationResponse {
    private String name;

    @Builder
    public StationCreationResponse(String name) {
        this.name = name;
    }
}
