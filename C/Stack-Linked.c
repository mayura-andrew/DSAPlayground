/**
 * @file Stack-Linked.c
 * @brief Implementation of a stack using linked list in C.
 */

#include <stdio.h>
#include <stdlib.h>

/**
 * @struct Node
 * @brief Structure representing a node in the stack.
 */
struct Node {
    int data;           /**< Data stored in the node */
    struct Node* link;  /**< Pointer to the next node */
};

struct Node* top = NULL;  /**< Pointer to the top of the stack */
int size = 0;             /**< Size of the stack */

/**
 * @brief Pushes an element onto the stack.
 * 
 * @param x The element to be pushed onto the stack.
 */
void Push(int x) {
    struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
    if (temp == NULL) {
        printf("Heap overflow\n");
        exit(1);
    }
    temp->data = x;
    temp->link = top;
    top = temp;
    size++;
}

/**
 * @brief Pops an element from the stack.
 */
void Pop() {
    struct Node* temp;
    if (top == NULL) {
        printf("Stack underflow\n");
        return;
    }
    temp = top;
    top = top->link;
    free(temp);
    size--;
}

/**
 * @brief Returns the top element of the stack.
 * 
 * @return The top element of the stack.
 */
int Top() {
    if (top == NULL) {
        printf("Stack is empty\n");
        return -1;
    }
    return top->data;
}

/**
 * @brief Prints the elements of the stack.
 */
void Print() {
    struct Node* temp = top;
    printf("Stack: ");
    while(temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->link;
    }
    printf("\n");
}

/**
 * @brief Checks if the stack is empty.
 * 
 * @return 1 if the stack is empty, 0 otherwise.
 */
int IsEmpty() {
    return top == NULL;
}

/**
 * @brief Returns the size of the stack.
 * 
 * @return The size of the stack.
 */
int Size() {
    return size;
}

/**
 * @brief The main function.
 * 
 * @return 0 on successful execution.
 */
int main() {
    // push elements onto the stack
    Push(10);
    Push(20);
    Push(30);

    // Pop elements from the stack
    Pop();
    Pop();

    if (IsEmpty()) {
        printf("Stack is empty\n");
    } else {
        printf("Stack is not empty\n");
    }
    Size();
    Print();
    return 0;
}