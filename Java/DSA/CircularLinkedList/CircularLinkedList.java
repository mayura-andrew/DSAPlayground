package CircularLinkedList;

import java.util.NoSuchElementException;

public class CircularLinkedList {
    private ListNode last;
    private int lenght;

    private class ListNode{
        private ListNode  next;
        private int data;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public CircularLinkedList() {
        last = null;
        lenght = 0;
    }

    public int lenght() {
        return lenght;
    }

    public boolean isEmpty() {
        return lenght == 0;
    }

    // Create an Circular Linked list

    public void createCircularLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;
    }

    // traversing and printing
    public void display() {
        if(last == null) {
            return;
        }

        ListNode first = last.next;
        while(first != last) {
            System.out.print(first.data + " ");
            first = first.next;
        }
        System.out.print(first.data);
    }

    // Insert node at the start of a circular signly linked list
    public void insertFirst(int data) {
        ListNode temp = new ListNode(data);
        if(last ==  null) {
            last = temp;
        } else {
            temp.next = last.next;
        }
        last.next = temp;
        lenght++;
    }

    // Insert a node at the end of 
    public void insertLast(int data) {
        ListNode temp = new ListNode(data);
        if(last == null) {
            last = temp;
            last.next = temp;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        lenght++;
    }
    // Remove first node 
    public int removeFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException("Circular Signly linked list is already empty");
        }
        ListNode temp = last.next;
        int result = temp.data;
        if(last.next == last) {
            last = null;
        } else {
            last.next = temp.next;
        }
        // temp.next = null; will automatically garbage collected
        lenght--;
        return result;
    }

    public static void main(String[] args) {
        CircularLinkedList csll = new CircularLinkedList();
        //csll.createCircularLinkedList();
        csll.insertFirst(10);
        csll.insertFirst(20);
        csll.insertLast(30);
        csll.insertLast(40);
        csll.display();
        csll.removeFirst();
        csll.display();
    }

}
