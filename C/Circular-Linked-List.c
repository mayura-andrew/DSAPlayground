#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

struct Node* head; // global variable, can be accessed anywhere

void Insert(int x) {
    // Allocate memory for a new node
    struct Node* temp = (struct Node*)malloc(sizeof(struct Node));

    // Set the data of the new node to the passed value
    temp->data = x;

    // Initially set the next of the new node to the current head
    temp->next = head;

    // If the list is not empty
    if (head != NULL) {
        // Find the last node in the list
        struct Node* last = head;
        while (last->next != head) {
            last = last->next;
        }

        // Make the next of the last node point to the new node
        last->next = temp;
    } else {
        // If the list is empty, make the new node point to itself
        temp->next = temp;
    }

    // Set the new node as the head of the list
    head = temp;
}
void Print() {
    // Start from the head node
    struct Node* temp = head;

    // If the list is not empty
    if (head != NULL) {
        // Do the following
        do {
            // Print the data of the current node
            printf(" %d", temp->data);

            // Move to the next node
            temp = temp->next;

        // Continue this process until we reach the head node again
        } while (temp != head);
    }

    // Print a newline character at the end
    printf("\n");
}

void InsertAtNthPosition(int data, int n) {
    // Allocate memory for a new node and set its data
    struct Node* temp1 = (struct Node*)malloc(sizeof(struct Node));
    temp1->data = data;
    temp1->next = NULL;

    // If the new node is to be inserted at the beginning of the list
    if (n == 1) {
        // If the list is empty, make the new node point to itself
        if (head == NULL) {
            temp1->next = temp1;
        } else {
            // If the list is not empty, make the new node point to the second node
            temp1->next = head->next;

            // Find the last node
            struct Node* last = head;
            while (last->next != head) {
                last = last->next;
            }

            // Make the last node point to the new node
            last->next = temp1;
        }

        // Make the new node the head of the list
        head = temp1;
        return;
    }

    // If the new node is to be inserted at a position other than the beginning
    // Find the (n-1)th node
    struct Node* temp2 = head;
    for (int i = 0; i < n - 2; i++) {
        temp2 = temp2->next;
    }

    // Insert the new node after the (n-1)th node
    temp1->next = temp2->next;
    temp2->next = temp1;
}

void Delete(int n) {
    // Start from the head node
    struct Node* temp1 = head;

    // If the node to be deleted is the head node
    if (n == 1) {
        // Find the last node in the list
        struct Node* last = head;
        while (last->next != head) {
            last = last->next;
        }

        // Make the last node point to the second node
        last->next = head->next;

        // Make the second node the new head of the list
        head = head->next;

        // Free the memory of the old head node
        free(temp1);
        return;
    }

    // If the node to be deleted is not the head node
    // Find the (n-1)th node
    for (int i = 0; i < n - 2; i++) {
        temp1 = temp1->next;
    }

    // Find the nth node
    struct Node* temp2 = temp1->next;

    // Make the (n-1)th node point to the (n+1)th node
    temp1->next = temp2->next;

    // Free the memory of the nth node
    free(temp2);
}


struct Node* Reverse(struct Node* head) {
    // Initialize three pointers to traverse the list and reverse the links
    struct Node* current = head;
    struct Node* prev = NULL;
    struct Node* next;

    // Traverse the list
    do {
        // Before changing next of current, store it
        next = current->next;

        // Now change next of current, this is where actual reversing happens
        current->next = prev;

        // Move prev and current one step forward
        prev = current;
        current = next;

    // Continue this process until we reach the head node again
    } while (current != head);

    // Change the next of the head node to the last node
    head->next = prev;

    // Change the head pointer to the last node
    head = prev;

    // Return the new head pointer
    return head;
}
int main() {
    Insert(2);
    Insert(4);  // Inserting 4 in the list
    Insert(6);  // Inserting 6 in the list
    InsertAtNthPosition(5, 2);  // Inserting 5 at position 2
    Print();  // Printing the list
    Delete(1);  // Deleting the first element
    Print();  // Printing the list after deletion
    head = Reverse(head);  // Reversing the list
    Print();  // Printing the list after reversing
    return 0;
}
