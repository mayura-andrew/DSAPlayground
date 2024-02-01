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

    // delete a node from a singly list at a given position
    public void delete(int position){
        // position is valid and starting from 1
        if(position == 1) {
            head = head.next;
        } else {
            ListNode previous = head; 
            int count = 1;
            while(count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;

        }
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

    // Reverse a Singly Linked List 
    public ListNode reverse(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
    // printing reverseList
    public void printReverseList(ListNode reverseListHead) {
        ListNode current = reverseListHead;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println();
    }

    //  get middle node of an array

    public ListNode getMiddleNode() {
        if(head == null) {
            return null;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr;

    }

    // find nth node from the end of a singly linked list
    public ListNode getNthNodeFromEnd(int n) {
        if(head == null ){
            return null;
        }

        if (n <= 0) {
            throw new IllegalArgumentException("Invalid value n = " + n);
        }

        ListNode mainPtr = head;
        ListNode refPtr = head;

        int count = 0;

        while(count < n) {
            if(refPtr == null) {
                throw new IllegalArgumentException(n + " is greater than the number of nodes in list ");
            } 
            refPtr = refPtr.next;
            count++;
        }

        while(refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }
    
    // Remove the duplicate nodes in sorted linked list

    public void removeDuplicates() {
        if (head == null) {
            return;
        }

        ListNode current = head;

        while(current != null && current.next != null) {
            if(current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    // Insert a node in a sorted Singly linked list
    public ListNode insertInSortedListNode(int value) {
        ListNode  newNode = new ListNode(value);

        if (head == null) {
            return newNode;
        }

        ListNode current = head;
        ListNode temp = null;

        while(current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }

        newNode.next = current;
        temp.next = newNode;
        return head;

    }

    // Remove a given key from singly linked list

    public void deleteNode(int key) {
        ListNode current = head;
        ListNode temp = null;

        if(current != null && current.data == key) {
            head = current.next;
            return;
        }

        while(current != null && current.data != key) {
            temp = current;
            current = current.next;
        }

        if(current == null) {
            return;
        }

        temp.next = current.next;

    }


    // detect a loop in a singly linked in list

    public boolean containsLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while(fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(slowPtr == fastPtr) {
                return true;
            }
        }
        return false;
    }

    // Finding start of a loop in a signly linked list
    public ListNode startNodeInALoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while(fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(fastPtr == slowPtr) {
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }


    private ListNode getStartingNode(ListNode slowPtr) {
        ListNode temp = head;
        while(temp != slowPtr) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp; // starting node of the loop
    }

    // removing loop from a singly linked list
    public void removeLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while(fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(fastPtr == slowPtr) {
                removeLoop(slowPtr);
                return;
            }
        }
    }

    public void removeLoop(ListNode slowPtr) {
        ListNode temp = head;
        while(temp.next != slowPtr.next) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
    }
    // creating a singly linked list with loop nodes
    public void creatALoopLinkedList() {
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(5);
        ListNode fourth = new ListNode(7);
        ListNode fifth = new ListNode(11);
        ListNode sixth = new ListNode(13);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = sixth;
    }


    // Merge two sorted lists

    public static ListNode merge(ListNode a, ListNode b) {
        // a --> 1 --> 2 --> 3 ---> 5 ---> null
        // b ---> 2 ---> 4 ---> 6 ---> null

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(a != null && b != null) {
            if(a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b; 
                b = b.next;
            }
            tail = tail.next;
        }

        // a --> 1 --> 3 ---> null
        // b --> 2 --> 3 ---> 4 ---> 6 --> 7 --> 9 --> 10 --> null

        if(a == null) {
            tail.next = b;
        } else {
            tail.next = a;
        }

        return dummy.next;

    }

    // add two numbers

    // TO-DO
    public ListNode add(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;

        while(a !=  null || b != null){
            int x = (a != null) ? a.val :0;
            int y = (b != null) ? b.val
        }
    }
    

    public static void main(String[] args) {
        // SinglyLinkedList sll = new SinglyLinkedList();
        // SinglyLinkedList.head = new ListNode(1);
        // ListNode second = new ListNode(1);
        // ListNode third = new ListNode(2);
        // ListNode fourth = new ListNode(3);

        // connect them together to form a chain of data

        // SinglyLinkedList.head.next = second; // 10 --> 1
        // second.next = third; // 10 --> 1 --->8
        // third.next = fourth; // 10 ---> 1 ---> 8 ---> 11 ---> null
     //   System.out.println(" ");
       // sll.display();
        // sll.insertFirst(3);
        // sll.insertFirst(3);
        // System.out.println(" ");
        // sll.insertLast(124);
        // sll.insertFirst(125);
        // System.out.println(" ");
        // sll.insert(5, 100);
        // sll.display();
        // int len = sll.length();
        // System.out.println(" ");
        // System.out.println("Length is --> " + len);
        // if(sll.find(SinglyLinkedList.head, 124)) {
        //     System.out.println("Search key found!!");
        // } else {
        //     System.out.println("Search Key not found !!!");
        // }
        // System.out.println(" ");
        // System.out.println(sll.deleteLast().data);
        // sll.display();
        // System.out.println(sll.deleteLast().data);
        // sll.display();
        // sll.delete(1);
        // System.out.println(" ");
        // sll.display();
        // sll.delete(1);
        // System.out.println(" ");
        // sll.display();

        // System.out.println(" ");
        // sll.display();
        // System.out.println(" ");
        // System.out.println(" Reverse Linked List ");
        // ListNode reverseListHead = sll.reverse(head);
        // sll.printReverseList(reverseListHead);


        // System.out.println(" ");
        // ListNode middleNode = sll.getMiddleNode();
        // System.out.println("Middle node is " + middleNode.data);

        // System.out.println(" ");

        // ListNode nthListNode = sll.getNthNodeFromEnd(3);
        // System.out.println("Nth node from end is - " + nthListNode.data);

        
        // sll.removeDuplicates();
        // sll.display();
        // System.out.println(" ");
        
        // sll.insertInSortedListNode(15);
        // sll.insertInSortedListNode(4);
        // sll.display();
        // System.out.println(" ");
        // System.out.println(" after deleting a node ");
        // sll.deleteNode(3);
        // sll.display();
        // System.out.println(" ");

        // System.out.println(" checking a loop ");
        // sll.creatALoopLinkedList();
        // System.out.println(sll.containsLoop());
        // System.out.println(sll.startNodeInALoop().data);
        // sll.removeLoop();
        // sll.display();
        // System.out.println(" ");
        // System.out.println(" ");


            System.out.println(" Two merge ");
            SinglyLinkedList sll1= new SinglyLinkedList();
            sll1.insertLast(1);
            sll1.insertLast(3);
            sll1.insertLast(4);
            sll1.display();
            System.out.println(" ");

            SinglyLinkedList sll2= new SinglyLinkedList();
            sll2.insertLast(3);
            sll2.insertLast(8);
            sll2.insertLast(9);
            sll2.insertLast(13);
            sll2.insertLast(18);

            sll2.display();
            System.out.println(" ");
            SinglyLinkedList result = new SinglyLinkedList();
            result.head = merge(sll1.head, sll2.head);
            result.display();


    }
}