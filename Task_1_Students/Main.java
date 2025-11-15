import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Student> students = new HashSet<>();

        students.add(new Student(
                "Жуков Александр", 101, 1,
                Map.of(
                        "Теоретическая механика", 5,
                        "Химия", 4,
                        "Практические занятия", 4
                )
        ));

        students.add(new Student(
                "Иванова Мария", 102, 1,
                Map.of(
                        "Теоретическая механика", 3,
                        "Химия", 3,
                        "Практические занятия", 3
                )
        ));

        students.add(new Student(
                "Кузнецов Олег", 101, 1,
                Map.of(
                        "Теоретическая механика", 2,
                        "Химия", 2,
                        "Практические занятия", 3
                )
        ));

        students.add(new Student(
                "Сергеев Дмитрий", 103, 2,
                Map.of(
                        "Теоретическая механика", 5,
                        "Химия", 4,
                        "Практические занятия", 5
                )
        ));

        // 1. ФИО + оценки
        System.out.println("Оценки студентов:");
        for (Student s : students) {
            System.out.println(s.getFullName());
            s.getGrades().forEach((subj, grade) ->
                    System.out.println("  " + subj + ": " + grade)
            );
        }

        // Обработка
        StudentUtils.expelBadStudents(students);
        StudentUtils.upgradeStudents(students);

        // 2. ФИО + средний балл
        System.out.println("\nСредний балл студентов:");
        for (Student s : students) {
            System.out.println(s.getFullName() +
                    " — средний балл: " + s.getAverage());
        }

        // 3. Отчисленные студенты
        System.out.println("\nОтчисленные студенты:");
        for (Student s : students) {
            if (s.isExpelled()) {
                System.out.println(s.getFullName() + " — ОТЧИСЛЕН");
            }
        }

        // 4. Студенты второго курса
        System.out.println("\nСтуденты второго курса:");
        StudentUtils.printStudentsOnCourse(students, 2);
    }
}
