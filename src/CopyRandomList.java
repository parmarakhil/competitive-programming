import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    Map<Node,Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node temp = new Node(head.val);
        map.put(head,temp);
        temp.next = copyRandomList(head.next);
        temp.random = map.get(head.random);
        return temp;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
