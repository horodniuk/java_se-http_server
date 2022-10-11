package lecture1_oop_classes_encapsulation.hometask.queue;

public class QueueTest {
    public static void main(String[] args) {
        /*   QueueComposition queueComposition = new QueueComposition();
        queueComposition.size();

        QueueInheritans queueInheritans = new QueueInheritans();
        queueInheritans.clear();*/

        QueueComposition q = new QueueComposition();
        for (int i = 0; i < 5; i++) {
            q.add(i);
        }
        while (q.size() > 0) {
            System.out.print(q.get() + " ");
        }
        System.out.println();



        System.out.println();

        System.out.println("~~~~~~~~~~~~~~");

        QueueInheritans q2 = new QueueInheritans();
        for (int i = 0; i < 5; i++) {
            q2.add(i);
        }
        while (q2.size() > 0) {
            System.out.print(q2.get() + " ");
        }
        System.out.println();

    }
}

