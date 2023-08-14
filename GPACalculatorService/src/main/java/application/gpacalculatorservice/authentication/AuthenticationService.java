package application.gpacalculatorservice.authentication;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String authUrl = "http://authentication:8082/auth/authenticate";
    public boolean authenticate(AuthenticationRequest authenticationRequest) {
        ResponseEntity<AuthenticationResponse> responseEntity = restTemplate.postForEntity(authUrl, authenticationRequest, AuthenticationResponse.class);
        return responseEntity.getBody().isAuthenticated();
    }
}
