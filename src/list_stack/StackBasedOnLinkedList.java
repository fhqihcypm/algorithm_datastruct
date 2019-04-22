package list_stack;

/**
 * 基于链表实现的栈
 */
public class StackBasedOnLinkedList {

    private Node head;

    public void push(int value) {
        Node node = new Node(value, null);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public int pop() {
        if (head == null) {
            return -1;
        }
        int result = head.data;
        head = head.next;
        return result;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.println(p.data + "->");
            p = p.next;
        }
    }
}
