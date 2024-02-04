package Stack;

import javax.management.RuntimeErrorException;

public class Stack_Array {
    private int top;
    private int[] arr;

    // constructor
    public Stack_Array(int capacity) {
        top = -1;
        arr = new int[capacity];
    }

    public Stack_Array() {
        this(10);
    }

    public boolean isFull() {
        return arr.length == size();
    }

    public int size() {
        return top + 1;
    }
    
    public void push(int data) {
        if(isFull()) {
            throw new RuntimeException("Stack is full !!!");
        }
        top++;
        arr[top] = data;
    }

    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("Stacj is empty");
        }
        int result = arr[top];
        top--;
        return result;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void display(){
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int peek() {
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return arr[top];
    }

    public static void main(String[] args){
        Stack_Array stack = new Stack_Array();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);
        stack.push(100);
        System.out.println("------");
        boolean em = stack.isEmpty();
        System.out.println(em);
        System.out.println("------");
        boolean f = stack.isFull();
        System.out.println(f);
        System.out.println("------");
        stack.display();
        System.out.println("------");
        int top = stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("------");
        System.out.println(top);
        System.out.println("------");
        stack.display();
        System.out.println("------");
        int peek = stack.peek();
        System.err.println(peek);
    }


}
