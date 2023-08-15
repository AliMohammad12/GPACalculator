package application.calculationservice.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GpaAnalyticsRepository extends MongoRepository<GpaAnalytics, String> {
}
