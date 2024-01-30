package DoublyLinkedList;

public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int lenght;

    private class ListNode {
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data) {
            this.data = data;
        }
    }

    // Constructor 
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.lenght = 0;
    }

    public boolean isEmpty() {
        return lenght == 0;  // head == null
    }

    public int length(){
        return lenght;
    }

    // print elements forward direction
    public void displayForward() {
        if(head == null ) {
            return;
        }

        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // print elements backword direction

    public void displayBackword() {
        if(tail == null) {
            return;
        }

        ListNode temp = tail;
        while(temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    // Insert an element at Last position
    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.previous = tail;
        tail = newNode;
        lenght++;
    }

    // Insert an element in beginning of the doubly linked list
    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        if(isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        lenght++;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        // dll.insertLast(1);
        // dll.insertLast(2);
        // dll.insertLast(3);
        dll.insertLast(7);

        dll.insertFirst(1);
        dll.insertFirst(2);
        dll.insertFirst(3);
        dll.insertFirst(4);

        dll.displayForward();
        dll.displayBackword();


    }



}
