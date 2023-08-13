package application.mongodbservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GpaAnalyticsService {
    private final GpaAnalyticsRepository gpaAnalyticsRepository;

    @Autowired
    public GpaAnalyticsService(GpaAnalyticsRepository gpaAnalyticsRepository) {
        this.gpaAnalyticsRepository = gpaAnalyticsRepository;
    }
    public GpaAnalytics saveGpaAnalytics(GpaAnalytics gpaAnalytics) {
        return gpaAnalyticsRepository.save(gpaAnalytics);
    }
    public List<GpaAnalytics> getAllGpaAnalytics() {
        return gpaAnalyticsRepository.findAll();
    }
}
