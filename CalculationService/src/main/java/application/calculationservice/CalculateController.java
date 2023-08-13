package application.calculationservice;

import application.calculationservice.readcourses.Course;
import application.calculationservice.readcourses.MySqlService;
import application.calculationservice.storeresult.MongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculateController {
    private CalculateService calculateService;
    private MySqlService mySqlService;
    private MongoDBService mongoDBService;
    @Autowired
    public CalculateController(CalculateService calculateService, MySqlService mySqlService) {
        this.calculateService = calculateService;
        this.mySqlService = mySqlService;
    }
    @RequestMapping("/calculate")
    public void calculate() {
        List<Course> courseList = mySqlService.getCourses();
        Double GPA = calculateService.calculate(courseList);
      //mySqlService.deleteCourses();

        mongoDBService.storeResult(GPA);
    }

}
