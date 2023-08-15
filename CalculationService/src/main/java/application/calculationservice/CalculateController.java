package application.calculationservice;

import application.calculationservice.readcourses.Course;
import application.calculationservice.readcourses.MySqlDatabase;
import application.calculationservice.storeanalytics.GpaAnalytics;
import application.calculationservice.storeanalytics.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculateController {
    private CalculateService calculateService;
    private MongoDatabase mongoDatabase;
    private MySqlDatabase mySqlDatabase;
    @Autowired
    public CalculateController(CalculateService calculateService, MongoDatabase mongoDatabase, MySqlDatabase mySqlDatabase) {
        this.calculateService = calculateService;
        this.mongoDatabase = mongoDatabase;
        this.mySqlDatabase = mySqlDatabase;
    }

    @RequestMapping("/calculate")
    public void calculate() throws Exception {
        List<Course> courseList = mySqlDatabase.getAllCourses();
        System.out.println("Here = " + courseList.size());
        GpaAnalytics gpaAnalytics = calculateService.getGpaAnalytics(courseList);
        storeAnalysis(gpaAnalytics);
    }
    @RequestMapping("/store-analysis")
    public void storeAnalysis(GpaAnalytics gpaAnalytics)  {
        mongoDatabase.saveGpaAnalytics(gpaAnalytics);
    }
}
