package application.showresultsservice;

import application.showresultsservice.mongodb.GpaAnalytics;
import application.showresultsservice.mongodb.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;


@Controller
public class ShowResultsController {
    private final MongoDatabase mongoDatabase;
    @Autowired
    public ShowResultsController(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    @GetMapping("/show-results")
    public String showResults(Model model) {
        List<GpaAnalytics> gpaAnalyticsList = mongoDatabase.getAllGpaAnalytics();
        model.addAttribute("gpaAnalyticsList", gpaAnalyticsList);
        clearData();
        return "show_results";
    }
    public void clearData() {
        mongoDatabase.deleteAll();
    }
}