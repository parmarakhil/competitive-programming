public class EqualTree {
    boolean isEqual = true;

    public void checkEqual(TreeNode p, TreeNode q){
        if(p==null || q==null){
            if(p==null && q!=null)
                isEqual = false;
            if(p!=null && q==null)
                isEqual = false;

            return;
        }

        if(p.val!=q.val){
            isEqual = false;
            return;
        }
        checkEqual(p.left, q.left);
        checkEqual(p.right, q.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        checkEqual(p, q);

        return isEqual;
    }

     public class TreeNode {
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
