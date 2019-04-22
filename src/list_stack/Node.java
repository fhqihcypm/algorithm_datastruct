package list_stack;

public class Node {
    public int data;
    public Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return "data = " + this.data;
    }
}
