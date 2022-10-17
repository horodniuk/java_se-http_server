package lecture1_oop_classes_encapsulation.hometask.singly_linked_list;

public class LinkedList {
    private Item first;
    private int size;

    public void add(int element) {
        if (size == 0) {
            first = new Item(element);
        } else {
            Item item = new Item(element);
            Item last = findItem(size - 1);
            last.setNext(item);
        }
        size++;
    }

    private Item findItem(int index) {
        int i = 0;
        Item current = first;
        while (i < size) {
            if (i == index) {
                return current;
            } else {
                i++;
                current = current.getNext();
            }
        }
        return null;
    }



    public int get(int index) {
        Item current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    public int remove(int index) {
        if (index == 0) {
            Item current = first;
            first = first.getNext();
            decrementSize();
            return current.getValue();
        } else {
            Item prevToRemove = findItem(index - 1);
            Item current = prevToRemove.getNext();
            prevToRemove.setNext(current.getNext());
            decrementSize();
            return current.getValue();
        }
    }

    private void decrementSize() {
        size--;
        if (size == 0) {
            first = null;
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        first = null;
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
