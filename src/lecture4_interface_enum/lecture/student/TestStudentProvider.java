package lecture4_interface_enum.lecture.student;

public class TestStudentProvider implements StudentProvider {

    @Override
    public Student[] getStudents() {
        return new Student[] {
                new Student("Ivan", "Ivanov", 22),
                new Student("Petr", "Petrov", 20),
                new Student("Sergey", "Sergeev", 24)
        };
    }
}
