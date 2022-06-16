import java.util.HashMap;

class LRUCache {

    Node head = new Node(0, 0);  // for key-value
    Node tail = new Node(0, 0);

    HashMap<Integer, Node> map = new HashMap<>();   // integer - key, Node - where there is our key

    int size;

// intially lets point head next to tail, and it's prev to head

    public LRUCache(int capacity) {
        size = capacity;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // to get a key - we will first search it our hashmap
        // if found:
        //      --> with the help of key-value - we will search that node
        //      --> remove that node, and place it in the fornt - as it is now recently used
        //      --> remove it from hashmap
        //      --> update the hashmap with the new node address
        // if not found:
        //      --> return -1

        if (map.containsKey(key) == true) {
            // found

            // store the node value from the hashmap
            Node temp = map.get(key);

            // remove this node
            remove(temp);

            // insert it now
            insert(temp);

            // now our insert and remove function - automatically changes our hashmap values too
            return temp.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        // now to put the key-value pair in our LRU cache we will have to keep track of our size

        // if the size of hashmap is lesser than the size allotted - we will insert it
        // if the size is equal, we will remove the element from last and insert it again

        // if map already contains the value we are abt to insert - then again remove it first and then insert

        if (map.containsKey(key) == true) {
            remove(map.get(key));
        }

        if (map.size() == size) {
            remove(tail.prev);  // reomve from back
        }

        Node temp = new Node(key, value);
        // insert it
        insert(temp);
    }

    // now we will make our basic - insert and delete operation
    private void insert(Node temp) {
        // always our insertion will happen from the head side - so as to denote that this is the most recently used one

        // before adding in our linked list - we will add this element in our hashmap too
        map.put(temp.key, temp);

        // now we will make the adjustments
        temp.next = head.next;
        head.next.prev = temp;
        head.next = temp;
        temp.prev = head;
    }

    private void remove(Node temp) {
        // to remove, we will delete from the tail side

        // first we will remove it from the hashmap
        map.remove(temp.key);

        // now from the list
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    class Node {
        // In this question we will be taking help of doubly linked list
        int value, key;
        Node next;
        Node prev;

        // these key-value pairs are used, as further we will be using hashmap too, so that the get(key) method can be implemented in O(1) time - as it is a search operation
        Node(int key1, int value1) {
            key = key1;
            value = value1;
        }
    }
}