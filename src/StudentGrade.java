import java.io.*;
import java.nio.file.*;
import java.util.*;

public class StudentGrade {

    public static void main(String[] args) {

        String path = "C:\\Users\\jorka\\IdeaProjects\\StudentGrades\\src\\java-backend-task-grades-console-data.csv";

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            List<Student> students = new ArrayList<>();

            for (int i = 1; i < lines.size(); i++) {
                String[] split = lines.get(i).split(",");
                String firstName = split[0].trim();
                String lastName = split[1].trim();
                String grade = split[2].trim();

                students.add(new Student(firstName, lastName, grade));
            }

            Collections.sort(students);
            students.forEach(System.out::println);

            double gpa = students.stream().mapToDouble(Student::getGradeValue).average().orElse(0.0);
            System.out.println("The GPA of all students: " + gpa);

        } catch (IOException e) {
            System.out.println("Error reading the file. " + e.getMessage());
        }
    }
}
