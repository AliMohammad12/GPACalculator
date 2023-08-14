package application.showresultsservice;

import application.showresultsservice.readanalytics.GpaAnalytics;
import application.showresultsservice.readanalytics.MongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;


@Controller
public class ShowResultsController {
    private final MongoDBService mongoDBService;

    @Autowired
    public ShowResultsController(MongoDBService mongoDBService) {
        this.mongoDBService = mongoDBService;
    }

    @GetMapping("/show-results")
    public String showResults(Model model) {
        System.out.println("Hey");
        List<GpaAnalytics> gpaAnalyticsList = mongoDBService.readResults();
        model.addAttribute("gpaAnalyticsList", gpaAnalyticsList);
        return "show_results";
    }
}