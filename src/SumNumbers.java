public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        return this.sumNumbers(root, sum);
    }

    public int sumNumbers(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        sum = 10 * sum + node.val;

        if (node.left == null && node.right == null) {
            return sum;
        }

        return sumNumbers(node.left, sum) + sumNumbers(node.right, sum);
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
