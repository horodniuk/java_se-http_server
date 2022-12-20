package lecture0_functional_programming.generic;

import java.util.ArrayList;

public class GenericExample {
    public static void main(String[] args) {
        /*IntegerCounter intCounter  = new IntegerCounter(1);
        intCounter.print();
        DoubleCounter doubleCounter = new DoubleCounter(2.0);
        doubleCounter.print();*/
        Counter<Integer> counterI = new Counter<>(1);
        counterI.print();

        Counter<Double> counterD = new Counter<>(2.0);
        counterI.print();

        ArrayList<Object> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        
        Integer i = (Integer) intList.get(1);

        printable("Strin");
        printable(1);
    }

        public static <T, U> void printable(T t){
             System.out.println("Tiron + " + t);
        }
}
