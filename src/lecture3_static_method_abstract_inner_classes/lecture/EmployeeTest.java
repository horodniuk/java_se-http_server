package lecture3_static_method_abstract_inner_classes.lecture;

public class EmployeeTest {
    public static void main(String[] args) {
        new Employee();
        new Employee();
        new Employee();
        new Employee();

        System.out.println(Employee.counter);
    }
}
