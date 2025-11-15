import java.util.Set;

public class StudentUtils {

    public static void expelBadStudents(Set<Student> students) {
        for (Student s : students) {
            if (s.getAverage() < 3) {
                s.expel();
            }
        }
    }

    public static void upgradeStudents(Set<Student> students) {
        for (Student s : students) {
            if (!s.isExpelled() && s.getAverage() >= 3) {
                s.setCourse(s.getCourse() + 1);
            }
        }
    }

    public static void printStudentsOnCourse(Set<Student> students, int course) {
        for (Student s : students) {
            if (!s.isExpelled() && s.getCourse() == course) {
                System.out.println(s.getFullName());
            }
        }
    }
}
