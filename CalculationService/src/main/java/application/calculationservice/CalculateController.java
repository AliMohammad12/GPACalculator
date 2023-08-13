package application.calculationservice;

import application.calculationservice.readcourses.Course;
import application.calculationservice.readcourses.MySqlService;
import application.calculationservice.storeresult.GpaAnalytics;
import application.calculationservice.storeresult.MongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculateController {
    private CalculateService calculateService;
    private MySqlService mySqlService;
    private MongoDBService mongoDBService;

    @Autowired
    public CalculateController(CalculateService calculateService,
                               MySqlService mySqlService, MongoDBService mongoDBService) {
        this.calculateService = calculateService;
        this.mySqlService = mySqlService;
        this.mongoDBService = mongoDBService;
    }

    @RequestMapping("/calculate")
    public void calculate() throws Exception {
        List<Course> courseList = mySqlService.getCourses();
        GpaAnalytics gpaAnalytics = calculateService.getGpaAnalytics(courseList);
        storeAnalysis(gpaAnalytics);
    }
    @RequestMapping("/store-analysis")
    public void storeAnalysis(GpaAnalytics gpaAnalytics) throws Exception {
        ResponseEntity<String> response =  mongoDBService.storeResult(gpaAnalytics);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new Exception ("Could not save data to MongoDB");
        }
    }
}
