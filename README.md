# LRU_cache
A custom implementation of the LRU (Least Recently Used) Cache data structure in Java, utilizing a hash table and a doubly linked list for $O(1)$ time complexity lookup and eviction.

# LRU Cache Implementation in Java

A Java-based implementation of the **Least Recently Used (LRU) Cache** data structure. This project demonstrates how to combine a **Custom Hash Table** with a **Doubly Linked List** to achieve $O(1)$ time complexity for both `get` and `put` operations.

## Features
- **$O(1)$ Fast Operations:** Constant time complexity for fetch and update actions.
- **Custom Data Structures:** Built using custom doubly linked list nodes and dynamic hashing mechanics.
- **Eviction Policy:** Automatically removes the least recently used item when the cache reaches its maximum capacity.
