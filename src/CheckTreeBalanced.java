public class CheckTreeBalanced {

    public static boolean checkTreeBalanced(TreeNode node) {
        if (helper(node) == -1) {
            return false;
        } return true;
    }

    private static  int helper(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = helper(node.left);
        int rightHeight = helper(node.right);
        if (leftHeight==-1 || rightHeight ==-1) {
            return -1;
        }
        if (Math.abs(leftHeight-rightHeight) >1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) +1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
