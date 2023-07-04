import java.util.*;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private String grade;
    private double gradeValue;

    private static final Map<String, Double> gradeMap = new HashMap<>();

    static {
        gradeMap.put("A", 4.0);
        gradeMap.put("B", 3.0);
        gradeMap.put("C", 2.0);
        gradeMap.put("D", 1.0);
        gradeMap.put("F", 0.0);
    }

    public Student(String firstName, String lastName, String grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.gradeValue = gradeMap.get(grade);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public double getGradeValue() {
        return gradeValue;
    }

    @Override
    public String toString() {
        return getFullName() + ": " + grade;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(other.gradeValue, this.gradeValue);
    }
}

