package lecture4_interface_enum.lecture;

import lecture4_interface_enum.lecture.student.Student;

public class MaxUtils {
    public static <T> T findMax(T[] array) {
        T max = null;
        if (array.length > 0) {
            max = array[0];
        }
        for (int i = 1; i < array.length; i++) {
            Comparable<T> current = (Comparable<T>) array[i];
            if (current.compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[] array1 = {"a", "b", "cc", "jack", "den", "eff" };
        System.out.println(findMax(array1));
        Integer[] array2 = {1, 2, 9, 3, 4, 5, 6, 7, 8};
        System.out.println(findMax(array2));
        Student[] students = {new Student("Ivan", "Ivanov", 22), new Student("Den", "Banks", 19),
                new Student("Petr", "Alexeev", 24)};
        System.out.println(findMax(students).getFullName());

    }
}
