package lecture2_oop_classes_inheritance_polymorphism.lecture;

public class Item{
    private Item next;
    private int value;
    private Item previous;

    Item(int value) {
        super();
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
