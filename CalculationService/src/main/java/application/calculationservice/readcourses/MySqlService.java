package application.calculationservice.readcourses;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class MySqlService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String mySqlDB_URL = "http://localhost:8084/mysqlDB-read";
    public List<Course> getCourses() {
        ResponseEntity<List<Course>> response = restTemplate.exchange(
                mySqlDB_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Course>>() {}
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return Collections.emptyList();
        }
    }
}
