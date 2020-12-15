package cn.leetcode.facetoface;

/**
 * 数组模拟队列
 *
 * @Author xiaoya.wen@raykite.com
 * @Date 2020/12/15  11:08
 **/
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(4);

        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);
//        arrayQueue.addQueue(4);
        System.out.println(arrayQueue.delQueue());
        System.out.println("=====================");
        arrayQueue.addQueue(5);
        arrayQueue.forEarch();
        System.out.println("=====================");
        arrayQueue.delQueue();
        arrayQueue.delQueue();
        arrayQueue.delQueue();
        arrayQueue.delQueue();
        arrayQueue.forEarch();
    }

}

class ArrayQueue {
    private int maxSize;
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr;
    private int total; // 有效元素个数

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[this.maxSize];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean iSFull() {

//        if (rear == 0 && front == 0) return false;
        return (rear + 1) % maxSize == front;
    }

    public void addQueue(int data) {
        if (iSFull()) throw new RuntimeException("队列已满");

//        if (rear + 1 == maxSize) {
//            rear = 0;
//
//        } else {
//            rear++;
//        }
        rear = (rear + 1) % maxSize;

        arr[rear] = data;
        System.out.println("rear = " + rear);
    }

    public int delQueue() {
        if (isEmpty()) throw new RuntimeException("队列为空");

        int data = arr[front];
        arr[front] = 0;
//        if (front + 1 == maxSize) {
//            front = 0;
//
//        } else {
//            front++;
//        }
        front = (front + 1) % maxSize;
        System.out.println("front = " + front);
        return data;
    }

    public void forEarch() {
        int count = (rear + this.maxSize - front) % maxSize; // 有效元素个数
        for (int i = front; i < front + count; i++) {
            System.out.println(arr[i % maxSize]);
        }
    }
}