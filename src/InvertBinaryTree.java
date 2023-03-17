public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode node = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(node);
        return root;
    }
}
