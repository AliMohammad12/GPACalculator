package application.calculationservice.storeresult;

import org.springframework.web.client.RestTemplate;

public class MongoDBService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String mongoDB_URL = "http://localhost:8088/mysqlDB-read";
    public void storeResult(Double gpa) {

    }
}
