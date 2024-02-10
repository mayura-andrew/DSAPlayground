public class BubbleSort {
    private long[] a;  // ref to array a
    private int nElemens; // number of data items

    // constructor 
    public BubbleSort(int max) {
        a = new long[max];
        nElemens = 0;
    }

    // put element into array
    public void insert(long value) {
        a[nElemens] = value;
        nElemens++;
    }

    public void display(){
        for(int j = 0; j < nElemens; j++) {
            System.out.print(a[j] + " "); 
        }
        System.out.println("");
    }


    // running time O(n^2)
    public void bubbleSort() {
        int out, in;

        for(out=nElemens-1; out > 1; out--) { // outer loop (backword)
            for(in=0; in<out; in++) { // inner loop (forward)
                if(a[in] > a[in+1] ){  //out of order ?
                    swap(in, in+1);  // swap them
                }
            }
        }
    }

    // Selection Sort
    public void selectionSort() {
        int out, in, min;

        for(out = 0; out < nElemens-1; out++) {
            min = out;
            for(in=out+1; in<nElemens; in++) {
                if(a[in] < a[min]) {
                    min = in;
                }
            }
            swap(out, min);
        }
    }

    // Insertion sort

    public void insertionSort() {
        int in, out;

        for(out = 1; out < nElemens; out++) { // out is dividing line
            long temp = a[out];  // remove marked item
            in = out;  // start shifts at out
            while(in > 0 && a[in-1] >= temp) { // until one is smaller
                a[in] = a[in-1];  // shift item right
                --in; // go left one position
            }
            a[in] = temp; // insert marked item
        }
    }

    private void swap(int one, int two){
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    public static void main(String[] args) {
        int maxSize = 100;

        BubbleSort arr;  //reference tp array
        arr = new BubbleSort(maxSize); // create the array

        arr.insert(12);
        arr.insert(23);
        arr.insert(13);
        arr.insert(10);
        arr.insert(1);
        arr.insert(4);

        arr.display();

      //  arr.bubbleSort();
     //   arr.selectionSort();
        arr.insertionSort();
        arr.display();



    }
}
