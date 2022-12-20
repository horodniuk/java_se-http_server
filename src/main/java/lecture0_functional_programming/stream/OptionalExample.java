package lecture0_functional_programming.stream;

import lecture_0_functional_programming.lecture.Student;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<Student> maybeStudent = Stream.of(
                new Student("Ivan", 18),
                new Student("Sveta", 23),
                new Student("Katya", 20),
                new Student("Den", 68),
                new Student("Andrey", 48),
                new Student("Kostya", 18)
                )
                .sequential()
                .filter(student -> student.getAge() < 18)
                .reduce((s1, s2) -> s1.getAge() > s2.getAge() ? s1 : s2 );

        maybeStudent.ifPresent(System.out::println);
        maybeStudent.map(Student::getAge);
    };
}
