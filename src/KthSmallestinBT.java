public class KthSmallestinBT {

        int count;
        int res;
        public int kthSmallest(TreeNode root, int k) {
            count = k;
            dfs(root);
            return res;
        }

        public void dfs(TreeNode root) {
            if(root == null) {
                return;
            }
            dfs(root.left);
            count--;
            if(count == 0) {
                res = root.val;
                return;
            }
            dfs(root.right);
        }
}
