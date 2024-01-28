public class Basic{
    public static void main(String[] args) {
        // Array declaration

        // <datatype> <arrayName>[];
        // <datatype>[] arrayName;

        int myArray[];
        int[] myArray1;


        // Initialization of an Array

        myArray = new int[3];

        // Inserting data into an array

        myArray[0] = 1;
        myArray[1] = 2;
        myArray[2] = 3;


        // Declaration and Initialization in same line

        // <datatype>[] <arrayName> = new <datatype>[size];
        // <datatype> <arrayName>[] = new <datatype>[size];

        int[] myArray2 =  new int[3];
        int myArray3[] = new int[4];

        int myArray4[] = {2, 4, 5 ,5};

        System.out.println(myArray4[1]);



    }
}