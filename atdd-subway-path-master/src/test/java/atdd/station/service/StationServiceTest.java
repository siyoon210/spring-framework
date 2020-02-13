package atdd.station.service;

import atdd.station.dto.StationCreationRequest;
import atdd.station.dto.StationCreationResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class StationServiceTest {
    @Autowired
    private StationService stationService;

    @Test
    @DisplayName("지하철 역 등록하기")
    public void createStation() {
        //given
        String stationName = "강남역";
        StationCreationRequest stationCreationRequest = new StationCreationRequest(stationName);
        
        //when
        StationCreationResponse stationCreationResponse = stationService.createStation(stationCreationRequest);

        //then
        assertThat(stationCreationResponse.getName(), is(stationName));
    }
}