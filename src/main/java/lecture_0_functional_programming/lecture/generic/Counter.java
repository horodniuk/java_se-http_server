package lecture_0_functional_programming.lecture.generic;

import java.io.Serializable;
import java.util.ArrayList;

public class Counter<T extends Serializable> {
    T t;

    public Counter(T t) {
        this.t = t;
    }

    public void print(){
        System.out.println(t);
    }



}
