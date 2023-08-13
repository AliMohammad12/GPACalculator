package application.mongodbservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GpaAnalyticsController {
    private final GpaAnalyticsService gpaAnalyticsService;

    @Autowired
    public GpaAnalyticsController(GpaAnalyticsService gpaAnalyticsService) {
        this.gpaAnalyticsService = gpaAnalyticsService;
    }

    @PostMapping("/api/gpa-analytics")
    public GpaAnalytics storeGpaAnalytics(@RequestBody GpaAnalytics gpaAnalytics) {
        System.out.println("Saving");
        return gpaAnalyticsService.saveGpaAnalytics(gpaAnalytics);
    }

    @RequestMapping("/api/gpa-analytics")
    public List<GpaAnalytics> getGpaAnalytics() {
        return gpaAnalyticsService.getAllGpaAnalytics();
    }
}
