package lrucache;


public class Main {
    public static void main(String[] args) {

        //create test cases to verify:
            //● correct insertion and retrieval tt
            //● correct update behavior tt
            //● correct eviction order (eviction==e25la2==tard) tt
            //● handling of edge cases such as empty cache or repeated access tt

        //must testing by:
            //● Insert until full capacity tt
            //● Access elements repeatedly tt
            //● Eviction correctness tt
            //● Updating existing keys tt
            //● Removing elements tt



        LRUCache cache = new LRUCache(3);//make cash with 3 element only to test edge cases easly

        System.out.println("----Testing Insertion until Full Capacity----");
        cache.put(1, 10); // [1]
        cache.put(2, 20); // [2, 1]
        cache.put(3, 30); // [3, 2, 1]
        System.out.print("Initial input(1, 2, 3)");
        printCacheState(cache);

        System.out.println();
        System.out.println("---Accessing elements----");
        System.out.println("Get 1: " + cache.get(1)); // return 10 and put it in the front
        System.out.print("After accessing 1 (1 should move to front)");
        printCacheState(cache);

        System.out.println();
        System.out.println("---Tests Eviction (Adding element to full cache)---");
        cache.put(4, 40); //must delete 2 and add 4 and move 4 at front
        System.out.println("Get 2 (should be evicted): " + cache.get(2)); // must return -1
        System.out.print("After adding 4 (2 should be gone)");
        printCacheState(cache);

        System.out.println();
        System.out.println("---Testing Update Behavior---");
        cache.put(3, 300); // update 3, 3 must go to front
        System.out.println("Get 3 (updated): " + cache.get(3)); // must return 300 the new value
        System.out.print("After updating 3 (3 moves to front)");
        printCacheState(cache);

        System.out.println();
        System.out.println("--- Testing Repeated Access ---");
        // 1 aslan fy el 2a5er
        cache.get(1); // b2a front
        cache.get(1); // hwa aslan front ,, bas mesh hydrab exception
        System.out.print("After repeated access to 1");
        printCacheState(cache);
    }
    // func tetabe3 tarteeb element fy elcash
    public static void printCacheState(LRUCache cache) {
        System.out.print("-> Order: ");
        Node temp = cache.list.head;
        while(temp != null){
            System.out.print("[" + temp.key + ":" + temp.value + "] ");
            temp = temp.next;
        }
        System.out.println();
    }
}
