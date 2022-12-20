package lecture0_functional_programming.generic;

import java.io.Serializable;

public class Counter<T extends Serializable> {
    T t;

    public Counter(T t) {
        this.t = t;
    }

    public void print(){
        System.out.println(t);
    }



}
