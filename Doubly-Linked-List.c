#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
    struct Node *prev;
};

struct Node *head = NULL;
struct Node *tail = NULL;

struct Node* getNode() {
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
    return newNode;
}

void insertFront(int item) {
    struct Node *ptr = getNode();
    ptr->data = item;
    
    if (head == NULL) {
        ptr->prev = ptr->next = NULL;
        head = tail = ptr;
    } else {
        ptr->prev = NULL;
        ptr->next = head;
        head->prev = ptr;
        head = ptr;
    }
}

void insertEnd(int item) {
    struct Node *ptr = getNode();
    ptr->data = item;
    
    if (tail == NULL) {
        ptr->prev = ptr->next = NULL;
        head = tail = ptr;
    } else {
        ptr->next = NULL;
        ptr->prev = tail;
        tail->next = ptr;
        tail = ptr;
    }
}

void deleteFront(void) {
    struct Node *ptr;
    if (head == NULL) {
        return;
    } else if (head->next == NULL) {
        ptr = head;
        head = tail = NULL;
    } else {
        ptr = head;
        head = head->next;
        head->prev = NULL;
    }
    free(ptr);
}

void deleteEnd(void) {
    struct Node *ptr;
    if (tail == NULL) {
        return;
    } else if (tail ->prev == NULL) {
        ptr = tail;
        head = tail = NULL;
    } else {
        ptr = tail;
        tail = tail -> prev;
        tail -> next = NULL;
    }
    free (ptr);
}

void printList() {
    struct Node* temp = head;
    while(temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

int main() {
    insertFront(1);
    insertFront(0);
    printList();
    insertEnd(5);
    insertEnd(10);
    insertEnd(15);
    printList();
    deleteFront();
    deleteEnd();
    printList();


}