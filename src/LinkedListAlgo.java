import java.util.HashSet;
import java.util.Set;

/**
 * 1）单链表反转；
 * 2）链表中环的检测；
 * 3）两个有序的链表合并
 * 4）删除链表倒数第N个结点
 * 5）求链表的中间结点
 */
public class LinkedListAlgo {

    /**
     * 链表反转:迭代法
     * 迭代法主要关注三个Node，即当前节点及前后节点
     * 先保存后节点，防止断链，然后反转当前节点的next
     * 
     * @param head
     * @return 反转后链表的头节点
     */
    public static Node reverse_Iterative(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 链表反转:递归法
     * 
     * 1. 先确定终止条件
     * 2. 推导递推公式，方法返回的都是最终的结果值
     * 
     * @param head
     * @return 反转后链表的头节点
     * 
     * LeeCode：https://leetcode.com/problems/reverse-linked-list/solution/
     */
    public static Node reverse_Recursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        Node previous = reverse_Recursive(head);
        previous.next.next = previous;
        previous.next = null;
        return previous;
    }

    /**
     * 检测链表是否有环 ： 龟兔赛跑
     * 把每个遍历过的节点保存在Set中，获取新的节点时判断是否在Set中，在则有环，所有的都不在则无环
     * @param node
     * @return
     */
    public static boolean checkCircle1(Node node) {
        if (node == null) return false;

        Node fast = node.next;
        Node slow = node;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) return true;
        }

        return false;
    }

     /**
     * 检测链表是否有环 ： 使用Set
     * 把每个遍历过的节点保存在Set中，获取新的节点时判断是否在Set中，在则有环，所有的都不在则无环
     * @param node
     * @return
     */
    public static boolean checkCircle(Node node) {
        Set<Node> usedSet = new HashSet<>();
        Node current = node;
        while(current != null) {
            if (usedSet.contains(current)) {
                return true;
            } else {
                usedSet.add(current);
                current = current.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node node4 = new Node(4, null);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        node4.next = node2;

        Node head = new Node(1, node2);  

        // Node result = LinkedListAlgo.reverse_Iterative(head);
        // while (result != null) {
        //     System.out.println(result.data);
        //     result = result.next;
        // }
        
        System.out.println(LinkedListAlgo.checkCircle1(head));
    }

    public static class Node {
        private int data;
        private Node next;

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
}