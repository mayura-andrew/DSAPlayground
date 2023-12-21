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
    nodePtr *curr, *head;
    int i;

    head = NULL;
    head = headInsert(head, 10);
    head = headInsert(head, 20);
    head = headInsert(head, 30);

    head = insertEnd(head, 40);
    head = insertEnd(head, 50);
    
    printList(head);

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

