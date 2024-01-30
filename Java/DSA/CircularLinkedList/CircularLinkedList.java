package CircularLinkedList;

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

    public static void main(String[] args) {
        CircularLinkedList csll = new CircularLinkedList();
        csll.createCircularLinkedList();
        csll.display();
    }

}
