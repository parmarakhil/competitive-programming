import java.util.ArrayList;

public class FlattenBinaryTree {
    ArrayList<TreeNode> l;
    public void preorder(TreeNode root){
        if(root==null) return;
        l.add(root);
        preorder(root.left);
        preorder(root.right);
    }

    public void flatten(TreeNode root) {
        if(root==null) return;
        l = new ArrayList<>();
        preorder(root);
        TreeNode prev = l.get(0);
        prev.left = null;

        for(int i=1; i<l.size(); i++){
            TreeNode curr = l.get(i);
            curr.left = null;
            prev.right = curr;
            prev = curr;
        }
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
