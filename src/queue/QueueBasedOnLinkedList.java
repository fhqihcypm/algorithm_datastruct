package queue;

import list_stack.Node;

/**
 * 基于链表实现的队列
 */
public class QueueBasedOnLinkedList {

    private Node head = null;
    private Node tail = null;

    public void enqueue(int value) {
        if (tail == null) {
            tail = new Node(value, null);
            head = tail;
        } else {
            tail.next = new Node(value, null);
            tail = tail.next;
        }
    }

    public int dequeue() {
        if (head == null) return -1;

        int result = head.data;

        head = head.next;
        if (head == null) {
            tail = null;
        }
        return result;
    }


}
