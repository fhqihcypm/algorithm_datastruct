package queue;

/**
 * 数据实现的环形队列
 */
public class CircularQueue {

    private int length ;
    private String[] items;

    private int head = 0;
    private int tail = 0;


    public CircularQueue(int capacity) {
        items = new String[capacity];
        length = capacity;
    }

    public boolean enqueue(String value) {
        //判断队列是否满了
        if ((tail + 1) % length == head) {
            return false;
        }
        items[tail] = value;
        tail = (tail + 1) % length;
        return true;
    }

    public String dequeue() {
        //队列为空
        if (head == tail) {
            return null;
        }
        String result = items[head];
        head = (head + 1) % length;
        return result;
    }

}
