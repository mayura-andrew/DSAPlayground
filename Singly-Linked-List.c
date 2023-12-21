/**
 * This program demonstrates various operations on a singly linked list.
 * It includes functions for inserting nodes at the beginning, end, and a specific location of the list,
 * deleting nodes from the beginning, end, and a specific location of the list,
 * concatenating two lists, calculating the length of a list,
 * and printing the elements of a list.
 *
 * The program defines a structure `node` with two members: `info` (an integer) and `next` (a pointer to the next node in the list).
 * It also defines a `typedef` for `struct node` called `nodePtr`.
 *
 * The program provides the following functions:
 * - `newNode`: Allocates memory for a new node and returns a pointer to it.
 * - `headInsert`: Inserts a new node at the beginning of the list.
 * - `insertEnd`: Inserts a new node at the end of the list.
 * - `insertSpeci`: Inserts a new node at a specific location in the list.
 * - `deleteFirst`: Deletes the first node from the list.
 * - `deleteEnd`: Deletes the last node from the list.
 * - `dele_spe`: Deletes a node with a specific value from the list.
 * - `concatenate`: Concatenates two lists.
 * - `length`: Calculates the length of a list.
 * - `freeList`: Frees the memory allocated for the list.
 * - `printList`: Prints the elements of the list.
 *
 * The program also includes a `main` function that demonstrates the usage of these functions.
 */
#include <stdio.h>
#include <stdlib.h>

struct node {
    int info;
    struct node *next;
};

typedef struct node nodePtr;

nodePtr* newNode() {
    nodePtr *ptr;
    ptr = (nodePtr *)malloc(sizeof(nodePtr));
    return ptr;
}

nodePtr* headInsert(nodePtr *list, int data) {
    nodePtr *curr;
    curr = newNode();

    if (curr == NULL) {
        printf("Error: Insufficient storage.\n");
        exit(1);
    }

    curr->info = data;
    curr->next = list;
    list = curr;
    return list;
}

nodePtr* insertEnd(nodePtr *list, int item) {
    nodePtr *ptr, *loc;
    ptr = newNode();

    ptr -> info = item;
    ptr -> next = NULL;

    if (list == NULL) {
        list = ptr;
    }
    else {
        loc = list;
        while (loc -> next != NULL) {
            loc = loc -> next;
        }
        loc -> next = ptr;
    }
    return(list);
}

nodePtr* insertSpeci(nodePtr *list, int item, int loc) {
    nodePtr *ptr, *temp;
    int k;
    for (k = 0, temp = list; k < loc; k ++) {
        temp = temp -> next;
        if (temp == NULL){
            printf("Node in the list at less than one");
            exit(1);
        }
    }
    ptr = newNode();
    ptr -> info = item;
    ptr -> next = temp -> next;
    temp -> next = ptr;
    return (list);
}


// This function insertSpeci is designed to insert a new node at a specific location in a singly linked list. Here's how it works:

// It takes three parameters: a pointer to the head of the list (list), the data to be added to the list (item), and the location at which the new node should be inserted (loc).

// It initializes a temporary pointer temp to the head of the list and a counter k to 0.

// It enters a loop that continues until k is less than loc. Inside the loop, it moves temp to the next node and increments k. If temp becomes NULL before k reaches loc, it means the list has fewer than loc nodes. In this case, it prints an error message and exits the program.

// After the loop, it creates a new node and sets its info to item.

// It inserts the new node after the node pointed to by temp by making next of the new node point to next of temp and next of temp point to the new node.

// Finally, it returns the head of the list.


nodePtr* deleteFirst(nodePtr *list) {
    nodePtr *ptr;

    if (list == NULL) {
        exit(1);
    }
    else {
        ptr = list;
        list = list->next;
        free(ptr);
    }
    return(list); 
}

nodePtr* deleteEnd(nodePtr *start) {
    nodePtr *ptr, *loc;
    if (start == NULL) {
        exit(1);
    } 
    else if (start -> next == NULL) {
        ptr = start;
        start = NULL;
        free (ptr);
    }
    else {
        loc = start;
        ptr = start -> next;
        while (ptr -> next != NULL) {
            loc = ptr;
            ptr = ptr -> next;
        }
        loc -> next = NULL;
        free(ptr);
    }
    return (start);
}

nodePtr* dele_spe(nodePtr *start){
    nodePtr *ptr, *loc;
    int temp;
    printf("Enter the element to delete");
    scanf("%d", &temp);
    ptr = start;
    if (start == NULL) {
        printf("Empty list");
        return start;
    } else {
        loc = ptr;
        while (ptr !=NULL) {
            if (ptr->info == temp){
                loc->next = ptr->next;
                free(ptr);
                return start;
            }
            loc = ptr;
            ptr = ptr->next;
        }
    }
    return start;
}

nodePtr* concatenate(nodePtr *list1, nodePtr *list2) {
    nodePtr *ptr;

    if (list1 == NULL) {
        return list2;
    }

    if (list2 == NULL) {
        return list1;
    }

    ptr = list1;
    while (ptr->next != NULL) {
        ptr = ptr->next;
    }

    ptr->next = list2;

    return list1;
}

// the length of a given list
int length(nodePtr *list) {
    nodePtr *curr = list;
    int count = 0;

    while (curr != NULL) {
        count++;
        curr = curr->next;
    }
    return count;
}

void freeList(nodePtr *list) {
    nodePtr *temp;

    while (list != NULL) {
        temp = list;
        list = list->next;
        free(temp);
    }
}
void printList(nodePtr *list) {
    nodePtr *curr;
    curr = list;

    while (curr != NULL) {
        printf("%d ", curr->info);
        curr = curr->next;
    }
    printf("\n");
}

int main() {
    nodePtr *head1 = NULL, *head2 = NULL;
    int i;

    // Insert nodes into the first list
    head1 = insertEnd(head1, 10);
    head1 = insertEnd(head1, 20);
    head1 = insertEnd(head1, 30);

    // Print the first list
    printList(head1);

    // Insert nodes into the second list
    head2 = insertEnd(head2, 40);
    head2 = insertEnd(head2, 50);
    head2 = insertEnd(head2, 60);

    // Print the second list
    printList(head2);

    // Concatenate the two lists
    head1 = concatenate(head1, head2);

    // Print the concatenated list
    printList(head1);

    // Delete the first node
    head1 = deleteFirst(head1);

    // Print the list after deletion
    printList(head1);

    // Delete a specific node
    head1 = dele_spe(head1);

    // Print the list after deletion
    printList(head1);

    // Print the length of the list
    printf("Length of the list: %d\n", length(head1));

    freeList(head1);


    return 0;
}


// 1. A structure `node` is defined with two members: `info` (an integer) and `next` (a pointer to the next node in the list).

// 2. A `typedef` is used to create an alias `nodePtr` for `struct node`.

// 3. The `newNode` function is defined. It allocates memory for a new node using `malloc` and returns a pointer to the newly allocated memory.

// 4. The `headInsert` function is defined. It inserts a new node at the beginning of the list. Here's how it works:

//    - It calls `newNode` to create a new node and assigns the returned pointer to `curr`.
   
//    - If `curr` is `NULL`, it means `malloc` failed to allocate memory. In this case, an error message is printed and the program exits with status code 1.
   
//    - If `curr` is not `NULL`, it means the new node was successfully created. The function then assigns `data` to the `info` member of the new node and makes `next` of the new node point to the first node of the list (`list`).
   
//    - Finally, it makes `list` point to the new node (which is now the first node of the list) and returns `list`.

