package application.calculationservice.readcourses;
public class Course {
    private Long id;
    private String name;
    private String grade;
    public Course(String courseName, String courseGrade) {
        name = courseName;
        grade = courseGrade;
    }
    public Course() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
