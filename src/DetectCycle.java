public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast!=slow){
            //if there is no cycle so they definately meet null situation
            if(fast==null || fast.next==null) return null;
            slow=slow.next;
            fast=fast.next.next;
        }
        //once cycle is found, the cycle causing node will be at same distance from the slow==fast meeting node and from the head node
        fast = head;
        while(fast!=slow){
            //moving both pointers by 1 and wherever they meet is will be the causing node;
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
