import java.util.Map;

public class Student {

    private String fullName;
    private int group;
    private int course;
    private Map<String, Integer> grades;
    private boolean expelled = false;

    public Student(String fullName, int group, int course, Map<String, Integer> grades) {
        this.fullName = fullName;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getFullName() {
        return fullName;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public boolean isExpelled() {
        return expelled;
    }

    public void expel() {
        this.expelled = true;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    public double getAverage() {
        return grades.values().stream()
                .mapToInt(i -> i)
                .average()
                .orElse(0);
    }
}
