package lrucache;


public class Node {

    int key;
    int value;
    Node prev;
    Node next;

    // Constructor
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
    //This node will be shared between the hash table and the linked list
}