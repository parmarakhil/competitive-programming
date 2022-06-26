public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)
            return null;
        return createBST(nums, 0, nums.length);
    }

    private TreeNode createBST(int arr[], int si, int ei){
        if(si<ei){
            int mi=(si+ei)/2;
            TreeNode root=new TreeNode(arr[mi]);
            root.left=createBST(arr, si, mi);
            root.right=createBST(arr, mi+1, ei);
            return root;
        }else
            return null;
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
