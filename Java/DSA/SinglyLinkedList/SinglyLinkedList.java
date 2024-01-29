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

        sll.display();
    }
}