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

    /**
     * 两个有序链表合并
     *
     * @param la
     * @param lb
     * @return
     */
    public static Node mergeSortedLists(Node la, Node lb) {
        if (la == null) return lb;
        if (lb == null) return la;

        Node p = la;
        Node q = lb;
        //确定头节点
        Node head;
        if (p.data < q.data) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }
        Node r = head;

        //遍历两个链表
        while (p != null && q != null) {
            if (p.data < q.data) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }

        //添加剩余的Node
        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }

        return head;
    }


    /**
     *  遍历两次
     *  1. 先计算链表的总长度
     *  2. 删除倒数第N个，即删除正数length - n + 1个
     * @return
     */
    public static Node removeNthFromEnd_1(Node head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0;
        Node first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        first = head;
        length = length - n ;
        while (length > 1) {
            length --;
            head = head.next;
        }
        head.next = head.next.next;
        return first;
    }

    /**
     *  遍历一次
     *  time complexity:O(n)  space complexity:O(1)
     *  使用两个指针curr、prev，其中curr比prev先行n步，当curr到达末尾时，
     *  prev所指的下一个元素即是要删除的元素
     * @return
     */
    public static Node removeNthFromEnd_2(Node head, int n) {
        Node dummy = new Node(0,head);
        Node curr = dummy;
        Node prev = dummy;

        while(n > 0){
            curr = curr.next;
            n--;
        }
        while(curr.next != null){
            curr = curr.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;

        return dummy.next;
    }

    // 求中间结点
    public static Node findMiddleNode(Node list) {
        if (list == null) return null;

        Node fast = list;
        Node slow = list;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     * 交换相邻的两个结点的值
     * https://leetcode.com/problems/swap-nodes-in-pairs/
     * @param head
     * @return
     */
    public static Node swapPairs(Node head) {
        if (head == null || head.next == null) return head;
        Node result = head.next;
        Node cur = head;
        Node pre = head;// 连接每对节点
        while (cur != null && cur.next != null) {
            pre.next = cur.next;
            Node next = cur.next.next; // next用来保存下一对节点的开始节点
            cur.next.next = cur;
            cur.next = next;
            pre = cur;// prev指向每一对反转之后节点的第二个节点
            cur = next;// cur指向每一对节点的第一个节点
        }
        return result;
    }

    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node head = new Node(1, node2);  

        // Node result = LinkedListAlgo.reverse_Iterative(head);
        // while (result != null) {
        //     System.out.println(result.data);
        //     result = result.next;
        // }
        System.out.println(head);
//        System.out.println(LinkedListAlgo.removeNthFromEnd_2(head, 2));
        System.out.println(LinkedListAlgo.swapPairs(head));
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