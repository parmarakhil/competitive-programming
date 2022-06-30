public class HasSumPath {


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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return this.preOrder(root, targetSum, 0);
    }

    public boolean preOrder(TreeNode root, int targetSum, int curr){
        if(root == null) return false;
        curr = curr + root.val;
        if(root.left == null && root.right == null && curr == targetSum) return true;
        return this.preOrder(root.left, targetSum, curr) || this.preOrder(root.right, targetSum, curr);
    }
}
