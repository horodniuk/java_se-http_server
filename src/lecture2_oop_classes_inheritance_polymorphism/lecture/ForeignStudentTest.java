package lecture2_oop_classes_inheritance_polymorphism.lecture;

public class ForeignStudentTest {
    public static void main(String[] args) {
        ForeignStudent s = new ForeignStudent("Jack", "Smith", 25, "english");
        System.out.println(s.getFullName());
    }

}
