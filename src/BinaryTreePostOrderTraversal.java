import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrderTraversal {
    List ans=new ArrayList<>();
    public List postorderTraversal(TreeNode root) {
        postorder(root);
        return ans;
    }
    void postorder(TreeNode curr){
        if(curr==null){
            return;
        }

        postorder(curr.left);
        postorder(curr.right);
        ans.add(curr.val);
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
