import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBT {

    private class Node {
        int data;
        Node left, right;
        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    Node root;

    // function to print Right view of
    // binary tree
    void rightView(Node root)
    {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            // get number of nodes for each level
            int n = q.size();

            // traverse all the nodes of the current level
            for (int i = 0; i < n; i++) {
                Node curr = q.peek();
                q.remove();

                // print the last node of each level
                if (i == n - 1) {
                    System.out.print(curr.data);
                    System.out.print(" ");
                }

                // if left child is not null add it into
                // the
                // queue
                if (curr.left != null) {
                    q.add(curr.left);
                }

                // if right child is not null add it into
                // the
                // queue
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        // Let's construct the tree as
        RightViewOfBT tree = new RightViewOfBT();
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        tree.root.right.left = tree.new Node(6);
        tree.root.right.right = tree.new Node(7);
        tree.root.right.left.right = tree.new Node(8);

        tree.rightView(tree.root);
    }
}
