package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class TestResults {
    public static class Student {
        private final String name;
        private final int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public int getScore() {
            return score;
        }

        public String getName() {
            return name;
        }
    }

    public static List<String> studentsThatPass(Stream<Student> students, int passingScore) {
        List<String> passStudents = new LinkedList<>();
        Consumer<Student> consumer = student -> {
            if (student.score >= passingScore) {
                passStudents.add(student.name);
            }
        };

        Comparator<Student> comparator = Comparator.comparingInt(Student::getScore);

        students.sorted(comparator.reversed()).forEach(consumer);

        return passStudents;
    }

    public static void main(String[] args) {

        List<Student> students = new ArrayList<Student>();

        students.add(new Student("Mike", 80));
        students.add(new Student("James", 57));
        students.add(new Student("Alan", 21));

        studentsThatPass(students.stream(), 50).forEach(System.out::println);
    }
}