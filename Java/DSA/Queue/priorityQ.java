package Queue;

import java.io.IOException;

class PriorityQ {
    // array is sorted order, from max at 0 to min at size -1
    private int maxSize;
    private long[] queArray;
    private int nItems;
    // constructor
    public PriorityQ(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }


    public void insert(long item) {
        int j;
        if(nItems==0) {
            queArray[nItems++] = item;
        } else {
            for(j=nItems-1; j>=0; j--) {
                if(item > queArray[j]) {
                    queArray[j+1] = queArray[j];
                } else {
                    break;
                }
            }
            queArray[j+1] = item;
            nItems++;
        }
        
    }

    public long remove() {
        return queArray[--nItems];
    }
    public long peekMin() {
        return queArray[nItems-1];
    }
    public boolean isEmpty() {
        return nItems==0;
    }
    public boolean isFull() {
        return (nItems == maxSize);
    }
}

class PriorityQApp {
    public static void main(String[] args) throws IOException {
        PriorityQ thePQ = new PriorityQ(5);
        thePQ.insert(30);
        thePQ.insert(40);
        thePQ.insert(10);
        thePQ.insert(20);
        thePQ.insert(60);

        while(!thePQ.isEmpty()) {
            long item = thePQ.remove();
            System.out.println(item + " ");
        }
    }
}
