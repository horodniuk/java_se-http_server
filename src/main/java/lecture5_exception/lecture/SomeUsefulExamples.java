package lecture5_exception.lecture;

import java.io.FileInputStream;
import java.io.IOException;

public class SomeUsefulExamples {
    public static void main(String[] args) {
        ret1();
        ret2();
        ret3();
        ret4();
        ret5();
        ret6();
        ret7();
    }



    private static int ret1() {
        try {
            return 0;
        } finally {
            return 1;
        }
    }

    private static void ret2(){
        try {
            System.out.println("try");
     //System.exit(0);
        } finally {
            System.out.println("finally");
        }
    }

    private static void ret3(){
        try {
            int c = 2 / 0;
            System.out.println(c);
        } finally {
            String s = null;
         //   System.out.println(s.length());
        }
    }

    private static void ret4(){
        try {
            int c = 2 / 0;
            System.out.println(c);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid argument");
        }
    }

    private static void ret5(){
        try {
            int c = 2 / 0;
            System.out.println(c);
        } catch (ArithmeticException e) {
            throw e;
        }
    }

    private static void ret6(){
        try {
            int c = 2 / 0;
            System.out.println(c);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Invalid argument", e);
// throw new IllegalArgumentException("Invalid argument");
        }
    }

    private static void ret7() {
        try {
            new FileInputStream("QQQQQQQQQQQQQQQQ");
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid argument", e);
        }
    }

}
