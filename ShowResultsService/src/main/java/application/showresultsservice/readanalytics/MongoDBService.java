package application.showresultsservice.readanalytics;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class MongoDBService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String mongoDB_URL = "http://localhost:8088/api/gpa-analytics";

    public List<GpaAnalytics> readResults() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<List<GpaAnalytics>> responseEntity = restTemplate.exchange(
                mongoDB_URL, HttpMethod.GET, new HttpEntity<>(headers),
                new ParameterizedTypeReference<List<GpaAnalytics>>() {});

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            return Collections.emptyList();
        }
    }
}
