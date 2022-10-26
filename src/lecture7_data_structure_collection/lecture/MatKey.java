package lecture7_data_structure_collection.lecture;

import java.util.Random;

public class MatKey {
    public int hashCode(int value) {
        return value;
    }

   /* public int hashCode() {
        return 1; //constant  O(n)
    }*/

    public int hashCode() {
        return new Random().nextInt();
    }





}
