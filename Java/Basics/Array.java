public class Array{
    public static void main(String[] args) {
        int total =0;
        // 1 st method
        int[] primes = {2, 3, 5, 6, 7, 8};
        for (int i = 0; i < primes.length; i++){
            total += primes[i];
            System.out.println(total);
        }

        for(int data: primes) {
            System.out.println(data);
        }
        int[] arr = {3, 5, 1, 4, 2};
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Max value: " + max);
        System.out.println("Min value: " + min);

        // 2nd method  new elementType[length]
        double[] measurements = new double[1000];
        // when arrays are created using the new operator, all of their elements are automatically,
        // assigned the default value for the element type. that is if the element type is numeric, all cell
        // of the array are initialized to zero, if the element type is boolean all cells are false, andd if the element,
        // type is a reference type (such as with an array of String instances) all cells are initialzed to null.
    }
}