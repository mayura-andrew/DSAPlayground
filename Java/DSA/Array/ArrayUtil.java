public class ArrayUtil {
    public void printArray(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void arrayDemo() {
        int[] myArray = new int[5]; 
        printArray(myArray);

        myArray[0] = 1;
        myArray[1] = 2;
        myArray[2] = 3;
        myArray[3] = 4;
        myArray[4] = 5;
        printArray(myArray);
    }

    // Remove items in the array :-> specific condition

    int[] removeEven(int[] arr) {
        int oddCount = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 != 0) {
                oddCount++;
            }
        }
        int[] result = new int[oddCount];
        int idx = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 !=0) {
                result[idx] = arr[i];
                idx++;
            }
        }
        return result;
    }

    // Reverse an Array
    public static void reverseArray(int numbers[], int start, int end) {
        while(start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
    }

    // Finding the minimum value in an array
    public int findMin(int[] arr) {
        // edge
        if(arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        int min = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    // finding the second max value 
    public int findSecondMax(int[] arr) {
        int max= Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    // Move zeroes to end of an Array;
    public void moveZeros(int[] arr, int n) {
        int j = 0; // j focus on zeroth elements
        for(int i = 0; i < n;  i++) { // i will focus non zero elements
            if(arr[i] != 0 && arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[j] != 0) {
                j++;
            }
        }
    }

    // Resize array

    public int[] resize(int[] arr, int capacity) {
        int[] temp = new int[capacity];
        for(int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }

    // Finding the missing number in the array

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int sum = n * (n+1) / 2;
        for (int num: arr) {
            sum -= num;
        }
        return sum;
    } 

    // isPalindrome string checking problem words like madam

    public boolean isPalindrome(String word){
        char[] charArray = word.toCharArray();

        int start = 0;
        int end = word.length() - 1;
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--; 
        }
        return true;

    }


    public static void main(String[] args) {

        ArrayUtil arrUtil = new ArrayUtil();
        int[] normalArray = new int[]{3, 5, 0, 0, 3, 4, 8, 0};
    //  arrUtil.arrayDemo();
    //  arrUtil.printArray(new int[] {3, 4, 5, 3});
    //  int[] oddNum = arrUtil.removeEven(new int[]{3, 5, 3, 4});
    //  arrUtil.printArray(oddNum);
     //   ArrayUtil.reverseArray(normalArray, 0, normalArray.length -1 );
      //  arrUtil.printArray(normalArray);

    //    int min = arrUtil.findMin(normalArray);
      //  System.out.println(min);

     //   int secondMax = arrUtil.findSecondMax(normalArray);
       // System.out.println(secondMax);

     //   arrUtil.moveZeros(normalArray, normalArray.length);
    
      //  arrUtil.printArray(normalArray);
      int[] resizedArray = arrUtil.resize(normalArray, 12);

      arrUtil.printArray(resizedArray);

      System.out.println(resizedArray.length);

      int missingNum =  ArrayUtil.findMissingNumber(new int[]{1, 2, 3, 5 , 6, 7});
      System.out.println(missingNum);

      boolean check = arrUtil.isPalindrome("madam");
      System.out.println(check);


    }
}
