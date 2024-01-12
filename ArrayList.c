#include <stdio.h>

#define MAX_SIZE 100

// Function to insert an element at the beginnig of the list
void insertAtBeginning(int list[], int *size, int element){
    if (*size < MAX_SIZE) {
        // Shift elements to make space for the new element
        for (int i = *size; i >0; i--) {
            list[i] = list[i - 1];
        }
        
        // Insert the new element at the beginnig
        list[0] = element;

        // Increment the size of the list
        (*size)++;
    } else {
        printf("Error: List is full, cannot insert at the beginning.\n");
    }
}

// Functipn to insert an element at the end of the list

void insertAtEnd(int list[], int *size, int element) {
    if (*size < MAX_SIZE) {
        // Insert the new element at the end
        list[*size] = element;

        // Increment the size of the list
        (*size)++;
    } else {
        printf("Error: List is full, cannot insert at the end.\n");
    }
}

// Function to insert an element at a specified position in the list
void insertAtPosition(int list[], int *size, int element, int position) {
    if (*size < MAX_SIZE && position >= 0 && position <= *size){
        // Shift elements to make space for the new element
        for (int i = *size; i > position; i--) {
            list[i] = list[i - 1];
        }

        // Insert the new element at the specified position
        list[position] = element;

        // Increment the size of the list
        (*size)++;
    } else {
        printf("Error: Unable to insert at the specified position.\n");
    }
}
// Function to display the elements of the list
void displayList(int list[], int size) {
    printf("List: ");
    for (int i = 0; i < size; i++) {
        printf("%d ", list[i]);
    }
    printf("\n");
}


int main(){
    printf("Hello world\n");
    int myList[MAX_SIZE];
    int size = 0;

    // Insert elements at the beginning
    insertAtBeginning(myList, &size, 1);
    insertAtBeginning(myList, &size, 2);
    insertAtBeginning(myList, &size, 3);
    insertAtBeginning(myList, &size, 4);

    // Displat the list after insertation at the beginnig
    displayList(myList, size);

    // Insert elements at the end
    insertAtEnd(myList, &size, 4);
    insertAtEnd(myList, &size, 5);
    insertAtEnd(myList, &size, 6);

    // Display the list after insertions at the end
    displayList(myList, size);

    // Insert an elemnt at the a ^th position
    int newPosition = 6;
    int newElement = 8;
    insertAtPosition(myList, &size, newElement, newPosition);

    // Display the list after the insertation at the a^th position
    displayList(myList, size);

    return 0;

}
