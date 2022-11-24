package lecture1_oop_classes_encapsulation.hometask.complexNumber;

public class ComplexTest {
    public static void main(String[] args) {
        Complex a = new Complex(1, 2);
        Complex b = new Complex(1, 2);

        System.out.println(a.getValue() + " + " + b.getValue() + " = " + a.add(b).getValue());
        System.out.println(a.getValue() + " - " + b.getValue() + " = " + a.sub(b).getValue());
        System.out.println(a.getValue() + " * " + b.getValue() + " = " + a.mul(b).getValue());
        System.out.println(a.getValue() + " / " + b.getValue() + " = " + a.div(b).getValue());
    }
}
