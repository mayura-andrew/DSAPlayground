public class Basic{
    public static void main(String[] args) {
        // Array declaration

        // <datatype> <arrayName>[];
        // <datatype>[] arrayName; 

      //  [2, 4, 5, 6, 7 , 7 ]; 

        int myArray[]; // method 1
        int[] myArray1; // method 2

        // Initialization of an Array

        myArray = new int[6];


        // Inserting data into an array

        myArray[0] = 1;
        myArray[1] = 2;
        myArray[2] = 3;

        


        // Declaration and Initialization in same line

        // <datatype>[] <arrayName> = new <datatype>[size];
        // <datatype> <arrayName>[] = new <datatype>[size];

        int[] myArray2 =  new int[10];

        boolean[] myar = new boolean[5];

        myArray2[0] = 1;
        myArray2[1] = 10;


        // for(int i = 0; i < myar.length; i++) {
        //     System.out.println("------");
        //     System.out.println(myar[i]);
        //     System.out.println("------");
        // }
        for (int a : myArray2) {
            System.out.println(a);
        }





       // int myArray3[] = new int[4];


        // additional method in java 

      //  int myArray4[] = {2, 4, 5 ,5};
     //   char  myArrayString[] = {'s', 'd', 'g'};

      //  System.out.println("Integer Array length " + myArray4.length);
       // System.out.println("Character Array Length is " + myArrayString.length);
 
       // System.out.println(myArray4[1]);
    }
}