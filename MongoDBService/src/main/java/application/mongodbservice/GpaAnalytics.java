package application.mongodbservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gpa_analytics")
public class GpaAnalytics {
    @Id
    private String id;
    private double gpa;
    private String highestMark;
    private String lowestMark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getHighestMark() {
        return highestMark;
    }

    public void setHighestMark(String highestMark) {
        this.highestMark = highestMark;
    }

    public String getLowestMark() {
        return lowestMark;
    }

    public void setLowestMark(String lowestMark) {
        this.lowestMark = lowestMark;
    }
}