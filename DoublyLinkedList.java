package lrucache;


public class DoublyLinkedList {
    Node head, tail;
        //● a head pointer representing the most recently used item
        //● a tail pointer representing the least recently used item


    public void addFirst(Node node){
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }

        head = node;
        if (tail == null) {
            tail = node;
        }
    }
    public void remove(Node node){
        //Remove a node from any position in the list.
        //Ensure correct pointer updates in all cases:
                //● removing the head
                //● removing the tail
                //● removing a middle node
        if (node == null) return;
        //● removing the head
        if (node == head){
            head = node.next;
        }
        //● removing the tail
        if (node == tail) {
            tail = node.prev;
        }
        //● removing a middle node
        if (node.prev != null){
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        //clear
        node.next = null;
        node.prev = null;
    }
    public void moveToHead(Node node){
        //invoke remove ,, addfirst
        //Update the position of a node after access.
        //This reflects that the item has been recently used.
        //The operation should:
                //● remove the node from its current position
                //● insert it again at the front
        if(node == null || node == head) return;
        remove(node);
        addFirst(node);
    }
    public Node removeTail(){
        //remove last ,, remove it from hash table
        //Return the removed node so it can also be deleted from the hash table.
        if (tail == null){
            return null;
        }
        Node nodeToDelete = tail;
        if (head == tail) {
            head = null;
            tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
        }
        nodeToDelete.prev = null;
        return nodeToDelete;
    }
}
