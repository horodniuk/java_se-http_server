package lecture0_functional_programming.stream;

import lecture_0_functional_programming.lecture.Student;

import java.util.stream.Stream;

public class MapReduceExample {
    public static void main(String[] args) {
        Stream.of(
                new Student("Ivan", 18),
                new Student("Sveta", 23),
                new Student("Katya", 20),
                new Student("Den", 68),
                new Student("Andrey", 48),
                new Student("Kostya", 11)
                ).parallel()
                .map(Student::getAge)
                .reduce(Math::max)
                .ifPresent(System.out::println);
    };
}
