package lecture1_oop_classes_encapsulation.hometask.matrix;

public class MatrixTest {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(2, 3);
        m1.fill(5);
        m1.print();

        System.out.println("-------------");
        Matrix m2 = m1.transpose();
        System.out.println("m2.rows=" + m2.getRows() + ", m2.cols=" + m2.getCols());
        m2.print();

        System.out.println("-------------");
        m1.print();
    }
}
