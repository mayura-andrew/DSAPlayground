public class Counter {
    private int count; // a simple integer instace variable
    public Counter(){} // default constructor (count is 0)
    public Counter(int initial) { count = initial;}  // an alternate constructor
    public int getCount() {  // an accessor method
        return count;
    }

    public void increment(){  // update method
        count++;
    }

    public void increment(int delta) {  // an update method
        count += delta;
    }

    public void reset() {  // an update method
        count = 0;
    }

    public static void main (String[] args) {
        Counter c;
        c = new Counter();
        c.increment();
        c.increment(1);
        int value = c.getCount();
        System.out.println(value);
    }
}


