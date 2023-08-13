package application.calculationservice.storeresult;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MongoDBService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String mongoDB_URL = "http://localhost:8088/api/gpa-analytics";
    public ResponseEntity<String> storeResult(GpaAnalytics gpaAnalytics) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<GpaAnalytics> httpEntity = new HttpEntity<>(gpaAnalytics, headers);
        return restTemplate.exchange(mongoDB_URL, HttpMethod.POST, httpEntity, String.class);
    }
}
