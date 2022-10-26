package lecture7_data_structure_collection.lecture;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeTest {
    private int value;

    public HashCodeTest(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashCodeTest)) return false;
        HashCodeTest that = (HashCodeTest) o;
        return getValue() == that.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    public static void main(String[] args) {
        Map<HashCodeTest, Object> map = new HashMap<>();
        HashCodeTest key = new HashCodeTest(5);
        map.put(key, new Object());
        System.out.println("before=" + map.containsKey(key));
        key.setValue(23);
        System.out.println("after=" + map.containsKey(key));
    }
}
