import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointer2 {

    public Node connect(Node root) {
        if(root==null) {
            return null;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size=queue.size();
            Node next=null;
            while(size-->0) {
                Node node = queue.poll();
                node.next = next;
                if(node.right!=null) {
                    queue.add(node.right);
                }
                if(node.left!=null) {
                    queue.add(node.left);
                }
                next=node;
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
