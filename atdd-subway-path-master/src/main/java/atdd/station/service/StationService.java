package atdd.station.service;

import atdd.station.domain.Station;
import atdd.station.dto.StationCreationRequest;
import atdd.station.dto.StationCreationResponse;
import atdd.station.repository.StationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StationService {
    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public StationCreationResponse createStation(StationCreationRequest stationCreationRequest) {
        Station station = stationRepository.save(stationCreationRequest.toEntity());
        return station.toStationCreationResponse();
    }
}
