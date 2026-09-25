package lrucache;


public class MyHashTable {
    Node[] table;
    int capacity;

    //Prepare fast access to cache elements.
    //Design a hash function that maps keys to indices.
    //Implement a hash table that stores:
        //● key mapped to node reference
        //Ensure proper handling of collisions.

    // ====== Task 7: Ali ======
    public MyHashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
    }

    public int hash(int key){
        return Math.abs(key) % capacity;
    }
    // ====== Task 8: Mazen ======
    public void insert(int key, Node node){
        int index = hash(key);
        int start = index;

        while (table[index] != null) {
            if (table[index].key == key) {
                table[index] = node;
                return;
            }
            index = (index + 1) % capacity;
            if (index == start) {
                throw new RuntimeException("Hash table is full");
            }
        }
        table[index] = node;
    }
    public Node search(int key){
        int index = hash(key);
        int start = index;

        while (table[index] != null) {
            if (table[index].key == key) {
                return table[index];
            }
            index = (index + 1) % capacity;
            if (index == start) {
                break;
            }
        }

        return null;
    }
    public void delete(int key){
        int index = hash(key);
        int start = index;

        while (table[index] != null) {
            if (table[index].key == key) {
                table[index] = null;
                rehashFrom(index);
                return;
            }
            index = (index + 1) % capacity;
            if (index == start) {
                break;
            }
        }
    }
    private void rehashFrom(int deletedIndex) {
        int index = (deletedIndex + 1) % capacity;

        while (table[index] != null) {
            Node nodeToMove = table[index];
            table[index] = null;
            insert(nodeToMove.key, nodeToMove);
            index = (index + 1) % capacity;
        }
    }
}
