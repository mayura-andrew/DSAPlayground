import java.util.Arrays;

public class BubbleSort1 {
    public void sort(int[] arr) {
        int n = arr.length;
        boolean isSwapped;

        for(int i = 0; i < n - 1; i++) {
            isSwapped = false;
            for(int j = 0; j < n - 1- i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if(isSwapped == false) {
                break;
            }
        }
    }

        public void printArray(int[] arr){
            for(int n = 0; n < arr.length; n++) {
                System.out.print(arr[n]);
            }
        }

        public static void main(String[] args) {
            int[] arr = new int[] {5, 1, 2, 9, 10};
            BubbleSort1 bs = new BubbleSort1();
            bs.printArray(arr);
            bs.sort(arr);
            System.out.println();
            bs.printArray(arr);
            System.out.println();
        }
} // Add the missing closing brace for the BubbleSort1 class.

