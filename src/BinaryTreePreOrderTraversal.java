import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreOrderTraversal {
    List ans = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode temp = root;
        if(temp != null ){
            ans.add(temp.val);

            preorderTraversal(temp.left);
            preorderTraversal(temp.right);
        }
        return ans;
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
