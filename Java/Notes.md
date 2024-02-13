# Notes 


## Array

**Disadvantages**

- In unordered array -> searching is slow, 
- Ordered array -> insertion is slow
- in both kinds of arrays, deletion is slow.
- the size of array can't be changed after it's created.

## Linked-List 

- in linked-list, each data item is embedded in a link. 
- each link object contains a reference (usually called next) to the next link in the list.
- ```java 
  class Link {
    public int iData; // data
    public double dData; // data
    public Link next; // reference to next link
  }


- this kind of class definition is sometimes called "self-referential" because it contains a field-called "**next**" in this case of the same type as itself.
- A **"reference"** is a number that refers to an object. it's the object's address in the computer's memory, but you don't need to know it's value; you just treat it as a magic number that tells you where the object is.
- in a list the only way to find a particular element is to follow along the chain of elements.

### Linked-List Efficiency

- Insertion and deletion at the beginning of a linked list are very fast. they involve changing only one or two references, which takes **"O(1)"** [Constant time] time.
- Finding, deleting, or inserting  next to a specific item requires searching through, on the average, half the items in the list.
- This requires O(n) for those operations, but the linked list is nevertheless faster because nothing needs to be moved when an item is inserted or deleted.
- The increased efficiency can be significant, especially if a copy takes much longer than a comparison.
- linked-list uses exactly as much memory as it needs and can expand to fill all of available memory. 

### Abstract data types 
- it's a way of looking at a data structures: focusing on what it does and ignoring how it does its job.

#### # note 
- in oop, an abstract data type is a class considered without regard to its implementation. it's description of the data in the class (fields), a list of operations (methods) that can be carried out on that data,
-  and instructions on how to use these operations. specifically excluded are the details of how the methods carry out their tasks. as a class user, you're told what methods to call, how to call them, and the results you can expect, but not how they work.
- the meaning of **"Abstract data type"** is further extended when it's applied to data structures such as stacks and queues. As with any class, it means the data and the operations that can be performed on it, but in this context even the fundamentals of how the data is stored become invisible to the user.  Users not only don't know how the methods work, they also don't know what structure is used to store the data. 
Example :- For the stack, the user knows that push() and pop() (and perhaps a few other methods) exist and how they work. the user doesn't (at least not usually) need to know how push() and pop() work, or whether data is stored in an array, a linked list or some other data structures like a tree.

### ADT Lists
 #### Lists -  is a group of items arranged in a linear order. 