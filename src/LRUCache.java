import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    MyNode head = new MyNode(0,0), tail = new MyNode(0,0);
    Map<Integer, MyNode> map = new HashMap<>();
    int capacity;
    LRUCache(int capacity){
        this.capacity=capacity;
    }

    int get(int key){
        if(map.containsKey(key)){
            MyNode node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }else return -1;
    }

    void put(int key, int value){
        if(map.containsKey(key)){
            map.remove(key);
        }
        if(map.size()==capacity){
            remove(tail.prev);
        }
        insert(new MyNode(key,value));
    }


    private void remove(MyNode node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev=node.prev;


    }
    private void insert(MyNode node) {
        map.put(node.key,node);
        MyNode nexHead = head.next;
        head.next=node;
        node.prev=head;
        nexHead.prev=node;
        node.next=nexHead;
    }


}
class MyNode{
     MyNode next,prev;
     int key,value;

     MyNode(int key, int value){
      this.key=key;
      this.value=value;
    }
}