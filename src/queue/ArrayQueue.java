package queue;

/**
 * 数组实现的队列
 */
public class ArrayQueue {

    //存储队列的元素
    private String[] items;
    //队列的长度
    private int n = 0;

    //队列的头
    private int head = 0;
    //队列的尾
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enqueue(String value) {
        if (tail == n) {
            return false;
        }
        items[tail++] = value;
        return true;
    }

    //出队
    public String dequeue() {
        if (head == tail) return null;
        return items[head++];
    }

    /**
     * 支持动态扩容的版本
     * 1. 出队时不需要做额外的操作
     * 2. 入队时如果队尾无空间，且队头不是数据的第0个元素，则说明有空闲空间
     *    只需移动数据即可
     */
    public boolean enqueueDynamic(String value) {
        //队尾无空间了
        if (tail == n) {
            if (head == 0) {//队头也无空间了，则整个队列满了
                return false;
            } else {
                //数据搬移
                for (int i = head; i < tail; i++) {
                    items[i -head] = items[i];
                }
                head = 0;
                tail -= head;
            }
        }

        items[tail++] = value;

        return true;
    }

}
