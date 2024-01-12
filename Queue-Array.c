/**
 * @file Queue-Array.c
 * @brief Implementation of a queue using an array in C.
 */

#include <stdio.h>
#define SIZE 5

int items[SIZE];
int front = -1, rear = -1;

// Function to check if the queue is full
int isFull(){
    if((front == rear +1) || (front == 0 && rear == SIZE-1)) return 1;
    return 0;
}

// Function to check if the queue is empty
int isEmpty(){
    if(front == -1) return 1;
    return 0;
}

// Function to insert an element into the queue
void enQueue(int element) {
    if(isFull()) printf("\n Queue is full!! \n");
    else {
        if(front == -1) front = 0;
        rear = (rear + 1) % SIZE;
        items[rear] = element;
        printf("\n Inserted -> %d", element);
    }
}

// Function to delete an element from the queue
int deQueue() {
    int element;
    if(isEmpty()) {
        printf("\n Queue is empty!");
        return(-1);        
    } else {
        element = items[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } /* Q has only one element, so we reset the queue after deleting it. */
        else {
            front = (front + 1) % SIZE;
        }
        printf("\n Deleted element -> %d \n", element);
        return(element);
    }
}

// Function to display the elements in the queue
void display() {
    int i; 
    if (isEmpty()) printf(" \n Empty Queue\n");
    else {
        printf("\n Front -> %d ", front);
        printf("\n Items -> ");
        for(i = front; i !=rear; i=(i+1)%SIZE) {
            printf("%d, ", items[i]);
        }
        printf("%d ", items[i]);
        printf("\n Rear -> %d \n", rear);
    }
}

int main() {
    // Filling the queue
    enQueue(1);
    enQueue(2);
    enQueue(3);
    enQueue(4);
    enQueue(5);

    // Displaying the queue
    display();

    // Removing elements from the queue
    deQueue();
    deQueue();

    // Displaying the queue after removing two elements
    display();

    return 0;
}