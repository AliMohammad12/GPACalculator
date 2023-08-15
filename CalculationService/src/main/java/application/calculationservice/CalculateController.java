package application.calculationservice;

import application.calculationservice.mysqldb.Course;
import application.calculationservice.mysqldb.MySqlDatabase;
import application.calculationservice.mongodb.GpaAnalytics;
import application.calculationservice.mongodb.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void calculate() {
        List<Course> courseList = mySqlDatabase.getAllCourses();
        GpaAnalytics gpaAnalytics = calculateService.getGpaAnalytics(courseList);
        storeAnalysis(gpaAnalytics);
    }
    @RequestMapping("/store-analysis")
    public void storeAnalysis(GpaAnalytics gpaAnalytics)  {
        mongoDatabase.saveGpaAnalytics(gpaAnalytics);
    }
}
