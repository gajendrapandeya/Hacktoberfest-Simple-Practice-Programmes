package JAVA;

import java.util.Arrays;

public class Gajendra_CustomQueueImpl {
    private int[] items;
    private int front;
    private int count;
    private int rare;

    public Gajendra_CustomQueueImpl(int capacity) {
        items = new int[capacity];
    }

    public void enqueue(int item) {
        if(isFull())
            throw new IllegalStateException();

        items[rare] = item;
        rare = (rare + 1) % items.length;
        count++;
    }

    public int dequeue() {

        if(isEmpty())
            System.out.println("empty");

        var item =  items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count --;
        return item;
    }

    public boolean isEmpty() {
        return front == rare;
    }

    public int peek() {
        return items[front];
    }

    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

    public static void main(String[] args) {

        var customQueue = new Gajendra_CustomQueueImpl(5);
        customQueue.enqueue(10);
        customQueue.enqueue(20);
        customQueue.enqueue(30);
        customQueue.enqueue(40);
        System.out.println(customQueue);
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.isFull());
    }
}
