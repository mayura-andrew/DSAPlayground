// /**
//  * @file Linked-List.c
//  * @brief Implementation of a linked list in C.
//  */

// #include <stdio.h>
// #include <stdio.h>
// #include <stdlib.h>

// struct Node {
//     int data;
//     struct Node* next;
// };

// struct Node* head; // global variable, can be accessed in anywhere

// /**
//  * @brief Inserts a new node at the beginning of the linked list.
//  * 
//  * @param x The data value to be inserted.
//  */
// void Insert(int x) {
//     struct Node* temp = (struct Node*)malloc(sizeof(struct Node));

//     temp->data = x;
//     temp->next = head;
//     head = temp;
// }


// struct Node* InsertReverse(struct Node* head, int data) {
//     struct Node *temp = (struct Node*)malloc(sizeof(struct Node));
//     temp->data = data; temp->next = NULL;
//     if(head == NULL) head = temp;
//     else {
//         struct Node* temp1 = head;
//         while(temp1->next != NULL) temp1 = temp1->next;
//         temp1->next = temp;
//     }
//     return head;
// }
// /**
//  * @brief Inserts a new node at the nth position in the linked list.
//  * 
//  * @param data The data value to be inserted.
//  * @param n The position at which the node should be inserted.
//  */
// void InsertAtNthPosition(int data, int n) {
//     struct Node* temp1 = (struct Node*)malloc(sizeof(struct Node));
//     temp1->data = data;
//     temp1->next = NULL;
//     if (n == 1) {
//         temp1->next = head;
//         head = temp1;
//         return;
//     }

//     struct Node* temp2 = head;
//     for (int i=0; i <n-2; i++) {
//         temp2 = temp2->next;
//     }
//     temp1->next = temp2->next;
//     temp2->next = temp1;
// }

// /**
//  * @brief Deletes the node at the nth position in the linked list.
//  * 
//  * @param n The position of the node to be deleted.
//  */
// void Delete(int n) {
//     struct Node* temp1 = head;
//     if (n == 1) {
//         head = temp1->next;
//         free(temp1);
//         return;
//     }
//     int i;
//     for (i = 0; i < n-2; i++) {
//         temp1 = temp1->next;
//     }
//     struct Node* temp2 = temp1->next;
//     temp1->next = temp2->next;
//     free(temp2);
// }

// struct Node* Reverse(struct Node* head) {
//     struct Node *current, *prev, *next;
//     current = head;
//     prev = NULL;
//     while(current != NULL) {
//         next = current->next;
//         current->next = prev;
//         prev = current;
//         current = next;
//     }
//     head = prev;
//     return head;
// }

// /**
//  * @brief Prints the elements of the linked list.
//  */
// void Print(struct Node* head) {
// //  //   struct Node* temp = head;
// //     printf("List is: ");
// //     while(temp != NULL){
// //         printf(" %d", temp->data);
// //         temp = temp->next; 
// //     }
// //     printf("\n");

//     while (head != NULL)
//     {
//         printf("%d", head->data);
//         head = head->next;
//     }
    
// }



// int main(){
//     // head = NULL; // empty list;
//     // printf("How many numbers?\n");
//     // int n, i, x;
//     // scanf("%d", &n);
//     // for(i = 0; i <n; i++){
//     //     printf("Enter the number \n");
//     //     scanf("%d", &x);
//     //     Insert(x);
//     //     Print();
//     // }

//     // // InsertAtNthPosition(3, 1);
//     // // InsertAtNthPosition(10, 3);
//     // // Print();
//     // // int y;
//     // // printf("Enter a position you want to delete ");
//     // // scanf("%d", &y);
//     // // Delete(n);
//     // Print();

//     struct Node* head = NULL;
//     head = InsertReverse(head, 2);
//     head = InsertReverse(head, 4);
//     head = InsertReverse(head, 6);
//     head = InsertReverse(head, 8);
//     Print(head);
//     printf("\n");
//     head = Reverse(head);
//     Print(head);
// }  


/**
 * @file Linked-List.c
 * @brief Implementation of a singly linked list in C.
 */

#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

struct Node* head; // global variable, can be accessed anywhere

/**
 * @brief Inserts a new node at the beginning of the linked list.
 * 
 * @param x The data value to be inserted.
 */
void Insert(int x) {
    struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
    temp->data = x;
    temp->next = head;
    head = temp;
}

/**
 * @brief Inserts a new node at the nth position in the linked list.
 * 
 * @param data The data value to be inserted.
 * @param n The position at which the node should be inserted.
 */
void InsertAtNthPosition(int data, int n) {
    struct Node* temp1 = (struct Node*)malloc(sizeof(struct Node));
    temp1->data = data;
    temp1->next = NULL;
    if (n == 1) {
        temp1->next = head;
        head = temp1;
        return;
    }

    struct Node* temp2 = head;
    for (int i=0; i <n-2; i++) {
        temp2 = temp2->next;
    }
    temp1->next = temp2->next;
    temp2->next = temp1;
}

/**
 * @brief Deletes the nth node from the linked list.
 * 
 * @param n The position of the node to be deleted.
 */
void Delete(int n) {
    struct Node* temp1 = head;
    if (n == 1) {
        head = temp1->next;
        free(temp1);
        return;
    }
    for (int i = 0; i < n-2; i++) {
        temp1 = temp1->next;
    }
    struct Node* temp2 = temp1->next;
    temp1->next = temp2->next;
    free(temp2);
}

/**
 * @brief Reverses the linked list.
 * 
 * @param head The head of the linked list.
 * @return The new head of the reversed linked list.
 */
struct Node* Reverse(struct Node* head) {
    struct Node *current, *prev, *next;
    current = head;
    prev = NULL;
    while(current != NULL) {
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }
    head = prev;
    return head;
}

/**
 * @brief Prints the elements of the linked list.
 */
void Print() {
    struct Node* temp = head;
    printf("List is: ");
    while(temp != NULL){
        printf(" %d", temp->data);
        temp = temp->next; 
    }
    printf("\n");
}

/**
 * @brief The main function.
 * 
 * @return 0 on successful execution.
 */
int main(){
    head = NULL; // empty list
    Insert(2); // Inserting at the beginning
    Print();
    InsertAtNthPosition(3, 2); // Inserting at the 2nd position
    Print();
    InsertAtNthPosition(4, 1); // Inserting at the beginning
    Print();
    Delete(2); // Deleting the 2nd node
    Print();
    head = Reverse(head); // Reversing the list
    Print();
    return 0;
}