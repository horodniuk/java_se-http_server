package lecture1_oop_classes_encapsulation.hometask.linkedList;

public class LinkedList {
    private Item first;
    private Item last;
    private int size;

    public void add(int element) {
        if (size == 0) {
            first = new Item(element);
        } else {
            int i = 0;
            Item current = first;
            while (i < size) {
                if (i == size - 1) {
                    last = current;
                    break;
                } else {
                    i++;
                    current = current.getNext();
                }
            }

            last.setNext(new Item(element));
        }
        size++;
    }



    public int get(int index) {
        Item current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    public int remove(int index) {
        if (size == 0) {
            first = null;
            return 0;
        }
        int removeElement = 0;
        if (index == 0) {
            removeElement = first.getValue();
            first = first.getNext();
        }  else{
            Item previous  = first;
            for (int i = 0; i < index-1; i++) {
                previous = previous.getNext();
                removeElement = previous.getNext().getValue();
            }
            Item changeLink = previous.getNext().getNext();
            previous.setNext(changeLink);

        }
        size--;
        return removeElement;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        first = last = null;
    }

    public int[] toArray() {
        int [] array = new int[size];
        Item current = first;
        for (int i = 0; i <= size-1; i++) {
            array[i] = current.getValue();
            current = current.getNext();
        }
        return array;
    }

}
