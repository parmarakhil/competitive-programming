public class CountCompleteTreeNodes {

    int ans = 0;
    private void inv(TreeNode root) {
        if(root == null) return;
        inv(root.left);
        ans++;
        inv(root.right);
        return;
    }
    public int countNodes(TreeNode root) {
        inv(root);
        return ans;
    }
}
