package lecture1_oop_classes_encapsulation.hometask.singly_linked_list;

public class Item {
    private Item next;
    private int value;
    private Item previous;
    Item(int value) {
        this.value = value;
    }
    Item getNext() {
        return next;
    }
    void setNext(Item next) {
        this.next = next;
    }
    int getValue() {
        return value;
    }
    Item getPrevious() {
        return previous;
    }
    void setPrevious(Item previous) {
        this.previous = previous;
    }
}
