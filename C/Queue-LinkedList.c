#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

struct Node *front = NULL;
struct Node *rear = NULL;
int size = 0;

void enQueue(int x) {
    struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
    temp->data = x;
    temp->next = NULL;
    if(front == NULL && rear == NULL) {
        front = rear = temp;
        return;
    }
    rear->next = temp;
    rear = temp;
    size++;
}

void deQueue() {
    struct Node* temp = front;
    if(front == NULL) {
        printf("Queue is Empty\n");
        return;
    }
    if (front == rear) {
        front = rear = NULL;
    } 
    else {
        front = front->next;
    }
    free(temp);
    size--; 
}

int getSize() {
    return size;
}

void Print() {
    struct Node* temp = front;
    while(temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}


int main() {
     // Filling the queue
    enQueue(1); Print();
    enQueue(2); Print();
    enQueue(3); Print();
    enQueue(4); Print();
    enQueue(5); Print();

    // Removing elements from the queue
    deQueue(); Print();
    deQueue(); Print();

    getSize();
    return 0;
}
