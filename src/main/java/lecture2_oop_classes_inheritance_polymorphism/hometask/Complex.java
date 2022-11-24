package lecture2_oop_classes_inheritance_polymorphism.hometask;

import java.util.Objects;

public class Complex extends Number {


    private double real;
    private double imaginary;

    private Complex() {
    }

    @Override
    public int intValue() {
        return (int) real;
    }

    @Override
    public long longValue() {
        return (long) real;
    }

    @Override
    public float floatValue() {
        return (float) real;
    }

    @Override
    public double doubleValue() {
        return (double) real;
    }

    public Complex(double real, double imaginary) {
        super();
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public String getValue() {
        return real + "+i*" + imaginary;
    }

    public Complex add(Complex secondArgument) {
        Complex result = new Complex(0,0);
        result.setReal(this.real + secondArgument.real);
        result.setImaginary(this.imaginary + secondArgument.imaginary);
        return result;
    }

    public Complex sub(Complex secondArgument) {
        Complex result = new Complex(0,0);
        result.setReal(real - secondArgument.real);
        result.setImaginary(imaginary - secondArgument.imaginary);
        return result;
    }

    public Complex mul(Complex secondArgument) {
        Complex result = new Complex(0,0);
        result.setReal(real * secondArgument.real - imaginary * secondArgument.imaginary);
        result.setImaginary(imaginary * secondArgument.real + real * secondArgument.imaginary);
        return result;
    }

    public Complex div(Complex secondArgument) {
        Complex result = new Complex();
        result.setReal((this.real * secondArgument.real + this.imaginary * secondArgument.imaginary)
                       / (secondArgument.real * secondArgument.real + secondArgument.imaginary * secondArgument.imaginary));
        result.setImaginary((this.imaginary * secondArgument.real - this.real * secondArgument.imaginary)
                            / (secondArgument.real * secondArgument.real + secondArgument.imaginary * secondArgument.imaginary));
        return result;
    }

    public static void main(String[] args) {
        Complex a = new Complex(1, 2);
        Complex b = new Complex(1, 2);

        System.out.println(a.getValue() + " + " + b.getValue() + " = " + a.add(b).getValue());
        System.out.println(a.getValue() + " - " + b.getValue() + " = " + a.sub(b).getValue());
        System.out.println(a.getValue() + " * " + b.getValue() + " = " + a.mul(b).getValue());
        System.out.println(a.getValue() + " / " + b.getValue() + " = " + a.div(b).getValue());
    }

    @Override
    public String toString() {
        return getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.getReal(), getReal()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReal());
    }
}
