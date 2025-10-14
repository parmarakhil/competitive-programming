import java.util.HashSet;

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


    public ListNode detectCycle1(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode temp = head;
        ListNode looped = null;
        while (temp!=null) {
            if (visited.contains(temp)) {
                return temp;
            }
            visited.add(temp);
            temp = temp.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next==null) return null;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        // identify loop
        while (fast!=slow) {
            if (fast==null || fast.next==null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        // now we know loop exists so find the now. Node will be equal distance from head and slow/fast
        slow = head;
        while (slow!=fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return null;
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
