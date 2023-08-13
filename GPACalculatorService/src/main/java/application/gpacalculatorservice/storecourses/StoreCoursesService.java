package application.gpacalculatorservice.storecourses;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StoreCoursesService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String mySqlDB_URL = "http://localhost:8084/mysqlDB/store";
    public ResponseEntity<String> storeCourses(StoreCoursesRequest storeCoursesRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<StoreCoursesRequest> httpEntity = new HttpEntity<>(storeCoursesRequest, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(mySqlDB_URL, HttpMethod.POST,
                httpEntity,
                String.class
        );
        return responseEntity;
    }
}
