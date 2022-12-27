package lecture10_jdbc.homework;

import java.util.List;

public interface StudentProvider {
    List<Student> findAll(int offset, int limit);
    long countAll();
    Student findById(Long id);
    List<Student> findByAge(int age, int offset, int limit);
    long countByAge(int age);
    void create(Student student);
    void update(Student student);
    void delete(Student student);
    void deleteById(Long id);
}
