package lecture2_oop_classes_inheritance_polymorphism.lecture;

public class DataSetTest {
    public static void main(String[] args) {
        DataSet dataSet = new DynaArray();
        for (int i = 0; i < 5; i++) {
            dataSet.add(i);
        }
        System.out.println(dataSet.toString());
        System.out.println("size " + dataSet.size); // ???????????
        System.out.println("size " + dataSet.size());

        dataSet.remove(0);
        dataSet.remove(0);

        System.out.println(dataSet);
        System.out.println("size" + dataSet.size());

        dataSet.clear();

        for (int i = 0; i < 100; i++) {
            dataSet.add(i);
        }

        System.out.println(dataSet.get(99));
        System.out.println(dataSet.get(999));

        System.out.println(dataSet.remove(99));
        System.out.println(dataSet.remove(999));
    }

}
