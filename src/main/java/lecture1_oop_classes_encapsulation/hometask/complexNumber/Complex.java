package lecture1_oop_classes_encapsulation.hometask.complexNumber;

public class Complex {
    private double real;
    private double imaginary;

    private Complex() {
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
}
