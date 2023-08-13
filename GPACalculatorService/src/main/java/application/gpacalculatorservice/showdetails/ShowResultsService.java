package application.gpacalculatorservice.showdetails;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

@Service
public class ShowResultsService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String showResults_URL = "http://localhost:8090/show-results";
    public RedirectView showResults() {
        return new RedirectView(showResults_URL);
    }
}
