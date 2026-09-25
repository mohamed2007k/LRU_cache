package lrucache;


public class LRUCache {
    int capacity;
    int currentSize;
    MyHashTable hashTable;
    DoublyLinkedList list;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        currentSize = 0;
        this.hashTable = new MyHashTable(capacity*2);//3ashn lw etmala mydarabsh exception
        this.list = new DoublyLinkedList();
    }

    //Capacity Handling and Testing
    //First, implement the capacity rule:
    //● if the cache is full:
    //○ remove the least recently used node from the list
    //○ remove its key from the hash table

    public int get(int key) {
        //○ return the value if it exists in hashTable
        //○ if it is in ?move the node to the front
        //if not return -1
        Node node = hashTable.search(key);
        if(node==null){return -1;}
        else{
            list.moveToHead(node);
            return node.value;
        }
    }
    public void put(int key, int value) {
        //○ insert a new item or update an existing one
        //○ move the node to the front
        //if cache is full remove tail from doublylinkedlist then from hashtable then add new node to head and to hashtable   
        Node node = hashTable.search(key);

        if(node!=null){
            node.value=value;
            list.moveToHead(node);
        }else{
            if (currentSize == capacity) {
                Node LRUnode = list.removeTail();
                if (LRUnode != null) {
                    hashTable.delete(LRUnode.key);
                    currentSize--;
                }
            }
            Node newNode = new Node(key, value);
            list.addFirst(newNode);
            hashTable.insert(key, newNode);
            currentSize++; //inc size after addition
        }
    }
}