package lecture10_jdbc.homework;

public class StudentProviderTest {
    public static void main(String[] args) {
        StudentProvider sp = new DatabaseStudentProvider();
        Student s = sp.findById(1L);
        System.out.println(s);
        s = new Student("test", "test", 19);
        sp.create(s);
        System.out.println(s);
    }

}
