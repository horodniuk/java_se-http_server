package lecture2_oop_classes_inheritance_polymorphism.lecture;

import lecture1_oop_classes_encapsulation.lecture.student.Student;

public class ForeignStudent extends Student {
    private String language;

    public ForeignStudent(String firstName, String lastName, int age, String language) {
        super(firstName, lastName, age);
        setLanguage(language);
        super.firstName = firstName;
    }

    public ForeignStudent() {
        super();
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
