package application.calculationservice.storeresult;

public class GpaAnalytics {
    private String id;
    private double gpa;
    private String highestMark;
    private String lowestMark;
    public GpaAnalytics(double gpa, String highestMark, String lowestMark) {
        this.gpa = gpa;
        this.highestMark = highestMark;
        this.lowestMark = lowestMark;
    }

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