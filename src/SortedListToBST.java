public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {

        if(head == null)return null;
        return SortedListTOBST(head,null);
    }
    public TreeNode SortedListTOBST(ListNode head, ListNode end){

        ListNode fast = head;
        ListNode slow = head;
        if(head == end)return null;
        while(fast != end && fast.next != end){
            fast = fast.next.next;
            slow=slow.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = SortedListTOBST(head,slow);
        node.right =SortedListTOBST(slow.next,end);

        return node;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
        public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
