package application.gpacalculatorservice.calculate;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CalculateGpaService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String authUrl = "http://localhost:8086/calculate";
    public void calculate() {
        restTemplate.getForObject(authUrl, Void.class);
    }
}
