import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SerialiseDeserialiseBT {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode root;

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root)
    {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        List<String> l = new ArrayList<>();
        while (!s.isEmpty()) {
            TreeNode t = s.pop();
            // If current node is NULL, store marker
            if (t == null) {
                l.add("#");
            }
            else {
                // Else, store current node and recur for
                // its children
                l.add("" + t.val);
                s.push(t.right);
                s.push(t.left);
            }
        }
        return String.join(",", l);
    }

    static int t;

    // Decodes your encoded data to tree.
    public  TreeNode deserialize(String data)
    {
        if (data == null)
            return null;
        t = 0;
        String[] arr = data.split(",");
        return this.helper(arr);
    }

    public  TreeNode helper(String[] arr)
    {
        if (arr[t].equals("#"))
            return null;
        // create node with this item and recur for children
        TreeNode root
                = new TreeNode(Integer.parseInt(arr[t]));
        t++;
        root.left = helper(arr);
        t++;
        root.right = helper(arr);
        return root;
    }

    // A simple inorder traversal used for testing the
    // constructed tree
    static void inorder(TreeNode root)
    {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    /* Driver program to test above functions*/
    public static void main(String args[])
    {
        // Let us construct a tree shown in the above figure
        SerialiseDeserialiseBT tree = new SerialiseDeserialiseBT();
        tree.root = tree.new TreeNode(20);
        tree.root.left = tree.new TreeNode(8);
        tree.root.right = tree.new TreeNode(22);
        tree.root.left.left = tree.new TreeNode(4);
        tree.root.left.right = tree.new TreeNode(12);
        tree.root.left.right.left = tree.new TreeNode(10);
        tree.root.left.right.right = tree.new TreeNode(14);

        String serialized = serialize(tree.root);
        System.out.println("Serialized view of the tree:");
        System.out.println(serialized);
        System.out.println();

        // Let us deserialize the stored tree into root1
        TreeNode t = tree.deserialize(serialized);

        System.out.println(
                "Inorder Traversal of the tree constructed from serialized String:");
        inorder(t);
    }

}
