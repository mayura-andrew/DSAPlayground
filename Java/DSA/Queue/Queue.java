package Queue;

import java.util.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue {
    private ListNode front;
    private ListNode rear;
    private int length;

    public Queue(){
        this.front = null;
        this.rear = null;
        this.length = 0;
    }
    private class ListNode{
        private int data;
        private ListNode next;

        @SuppressWarnings("unused")
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0; 
    }

    // data interting at rear (end)

    public void enqueue(int data) {
        ListNode temp = new ListNode(data);
        if(isEmpty()) {
            front = temp;
        }else {
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

    // data deleting at front (start)
    public int dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException("Queue is already empty");
        }

        int result = front.data;
        front = front.next;
        if(front == null) {
            rear = null;
        }
        length--;
        return result;
    }

    public int first() {
        if(isEmpty()) {
            throw new NoSuchElementException("Queue is already empty");
        }
        return front.data;
    }
    
    public int last() {
        if(isEmpty()) {
            throw new NoSuchElementException("Queue is already empty");
        }
        return rear.data;
    }

    String[] generateBinaryNumbers(int n) {
        String[] result = new String[n];
        Queue <String> q=  new LinkedList<>();
        q.offer("1");

        for(int i=0; i < n; i++) {
            result[i] = q.poll();
            String n1 = result[i] + "0";
            String n2 = result[i] + "1";
            q.offer(n1);
            q.offer(n2);
        }
        return result;
    }
 
    public void print() {
        if(isEmpty()) {
            return;
        }
        ListNode current = front;
        while (current != null) {
            System.out.print(current.data + " ---> ");
            current = current.next;
        }
        System.out.println("null");
    }



    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.print();
      //  queue.dequeue();
        queue.print();
        System.out.println("First ---> " + queue.first());
        System.out.println("Last ---> " + queue.last());

    }
}



