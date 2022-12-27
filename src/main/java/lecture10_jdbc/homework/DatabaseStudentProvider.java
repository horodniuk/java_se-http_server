package lecture10_jdbc.homework;

import java.util.List;

public class DatabaseStudentProvider implements StudentProvider {
    @Override
    public List<Student> findAll(int offset, int limit) {
        return null;
    }

    @Override
    public long countAll() {
        return 0;
    }

    @Override
    public Student findById(Long id) {
        return null;
    }

    @Override
    public List<Student> findByAge(int age, int offset, int limit) {
        return null;
    }

    @Override
    public long countByAge(int age) {
        return 0;
    }

    @Override
    public void create(Student student) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(Student student) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
