## Base Types

### boolean :- a boolean value: true and false
### char :- 16-bit Unicode character
### byte :- 8-bit signed two's complement integer
### short :- 16-bit signed two's complement integer
### int :- 32-bit signed two's complement integer
### long :- 64-bit signed two's complement integer
### float :- 32-bit floating-point number (IEEE 754-1985)
### double :- 64-bit floating-point number (IEEE 754-1985)


## Note

#### A nice feature of Java is that when base-type variables are declared as instance
#### variables of class. Java ensures initial default values if not explicitly initialized.
#### In particular, all numeric types are initialized to zero, a boolean is initialed to false, and a
#### character is initialized to the null character by default.

#### -> If there are several methods with same name defined for a class, then
#### the Java runtime system uses the one that matches the actual number of parameters sent as arguments, as well as 
#### thier respective types.


#### -> A method's name combined with the number and types of its parameters is called a method's signature, for it takes 
#### all of these parts to determine the actural method to perform for a certain method call.

### however, that the signature of a method in java does not include the type that the method returns so Java does not allow
### two methods with the same signature to return different types.

## Arrays 

####  A common programming task is to keep track of an ordered sequence of related values or objects. 
insdead of different varibales --> one array for that, we would prefer to use a single name for the group and use index 
numbers to refer to keep track of the data.

## Array -> which is a sequenced collection of variables all of the same type. 
## each variable, or cell in an array has an index, which uniquely refers to the value stored in that cell.

data item in the array -> element
the maximum number of things that can be stored in the array --> capacity
buffer overflow attack.

elementType[] arrayName = {initialValue0, initialValue1, ---- initialValueN-1};

## Casting --> is an operation that allows us to change the type of a vlue
## explicit and Implicit casting

## An ADT is a mathematical model of a data structure that specifies the type of data stored, the operations supported 
## them, and the types of parameters of the operations.

## An ADT specifies what each operation does,  but not how it does it. 
## An ADT specifies what each operation does,  but not how it does it. 
## in the JAVA, an ADT can be expressed by an interface, which is simply a list of method declarations, where each method has 
## an emtpy body.
