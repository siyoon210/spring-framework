package atdd.station.controller;

import atdd.station.dto.StationCreationRequest;
import atdd.station.dto.StationCreationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stations")
public class StationController {
    @PostMapping
    public ResponseEntity<StationCreationResponse> createStation(StationCreationRequest stationCreationRequest) {
        return null;
    }
}
