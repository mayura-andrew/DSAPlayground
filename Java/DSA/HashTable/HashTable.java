package HashTable;

public class HashTable {
    private HashNode[] buckets;
    private int numOfBuckets;  // capacity 
    private int size; // number of key value pairs in hash table or number of hash nodes in a HashTable


    public HashTable() {
        this(10);
    }


    public HashTable(int capacity) {
        this.numOfBuckets = capacity;
        this.buckets = new HashNode[numOfBuckets];
        this.size = 0; 
    }

    public class HashNode {
        private Integer key;
        private String value;
        private HashNode next;

        public HashNode(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    // Insert
    public void put(Integer key, String value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or Value is null !!!");
        }

        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while(head != null) {
            if(head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets[bucketIndex];
        HashNode node = new HashNode(key, value);
        node.next = head;
        buckets[bucketIndex] = node;
    }

    private int getBucketIndex(Integer key) { // hashcode function
        return key % numOfBuckets;
    }

    // Search
    public String get(Integer key){
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while(head!=null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    // remove
    public String remove(Integer key) {
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode previous = null;
        while (head!=null) {
            if(head.key.equals(key)) {
                    break;
            }
            previous = head;
            head = head.next;
        }
        if(head == null){
            return null;
        }
        size--;
        if(previous != null) {
            previous.next = head.next;
        } else {
            buckets[bucketIndex] = head.next;
        }
        return head.value;
    }
    
    public static void main(String[] args) {
        HashTable table = new HashTable(10);
        table.put(104, "John");
        table.put(20, "Andrew");
        table.put(21, "Tim");
        table.put(31, "Michel");
        table.put(41, "achintha");
        table.put(14, "ann");
        table.put(41, "Twest");
        System.out.println(table.size());
        System.out.println(table.get(20));
    }
}
