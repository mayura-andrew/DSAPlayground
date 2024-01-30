import java.util.List;

public class SinglyLinkedList{
    private ListNode head;

    // Inner class
    private static class ListNode{
        private int data; // generic type
        private ListNode next;

        // Contructor
        private ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    // Print elements of a Singly Linked List
    public void display() {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.data + " ---> ");
            current = current.next;
        }
        System.out.print("null");
    }

    // Find length of the singly linked list
    public int length() {
        if(head == null) {
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Insert node at the beginning of the signgly Linked List
    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    // Insert node at the end of signly Linked list
    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if(head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while(null != current.next) {
            current = current.next;
        }
        current.next = newNode;

    }

    // Insert node in a given position
    public void insert(int position, int value) {
        // 1 -> 4 -> 5
        // 1 -> 6 -> 4 -> 5
        ListNode node = new ListNode(value);

        if(position == 1) {
            node.next = head;
            head = node;
        } else {
            ListNode previous = head;
            int count = 1; // position - 1

            while(count < position -1 ){
                previous = previous.next;
                count++;
            }

            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }
    // Delete first node

    public ListNode deleteFirst(){
        if(head == null) {
            return null;
        }

        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    // Delete last node
    public ListNode deleteLast() {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;

        while(current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null; // break the chain
        return current;

    }

    // Search a particular value/key

    public boolean find(ListNode head, int searchKey){
        if (head == null) {
            return false;
        }

        ListNode current = head;
        while (current != null) {
            if(current.data == searchKey){
                return true;
            }
            current = current.next;
        }
        return false;
    }



    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        // connect them together to form a chain of data

        sll.head.next = second; // 10 --> 1
        second.next = third; // 10 --> 1 --->8
        third.next = fourth; // 10 ---> 1 ---> 8 ---> 11 ---> null
        System.out.println(" ");
        sll.display();
        System.out.println(" ");
        sll.insertFirst(2);
        sll.insertFirst(3);
        System.out.println(" ");
        sll.insertLast(123);
        sll.insertLast(124);
        sll.display();
        System.out.println(" ");
        sll.insert(5, 100);
        sll.display();
        int len = sll.length();
        System.out.println(" ");
        System.out.println("Length is --> " + len);
        if(sll.find(sll.head, 124)) {
            System.out.println("Search key found!!");
        } else {
            System.out.println("Search Key not found !!!");
        }
        System.out.println(" ");
        System.out.println(sll.deleteLast().data);
        sll.display();
        System.out.println(sll.deleteLast().data);
        sll.display();

    }
}