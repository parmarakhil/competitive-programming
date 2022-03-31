public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        // Base condition
        if(head == null) return head;

        // Make two nodes for two linkedlist
        ListNode sn = new ListNode(-1), sp = sn;
        ListNode ln = new ListNode(-1), lp = ln;

        // Loop till end
        ListNode curr = head;
        while(curr != null) {
            // check if the value of curr is less than x
            // Attach it to small curr(sp)
            if(curr.val < x) {
                sp.next = curr;
                sp = sp.next;
            } else {
                // else attach it to large curr(lp)
                lp.next = curr;
                lp = lp.next;
            }
            // increase curr at every step
            curr = curr.next;
        }
        //Attach sp next to ln next
        sp.next = ln.next;
        // Make lp next to null because it is not pointing to null
        lp.next = null;
        // return new head that it sn next
        return sn.next;
    }
}
