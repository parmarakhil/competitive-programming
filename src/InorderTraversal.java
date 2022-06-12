import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> output = new ArrayList<>();
        if(root==null) return output;
        TreeNode curr = root;
        while(curr!=null || !stack.empty()){
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr = stack.pop();
            output.add(curr.val);
            curr = curr.right;
        }
        return output;
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

