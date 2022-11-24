package lecture3_static_method_abstract_inner_classes.lecture;

public class Employee {
    protected static int counter = 1;
    private final int number;
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        super();
        this.number = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee() {
        super();
        this.number = counter++;
    }

    public int getNumber() {
        return number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
