public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int count = 0;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        int i = count - n;
        curr = head;
        if(i==0) {
            return curr.next;
        }
        while(i > 1) {
            curr = curr.next;
            i--;
        }
        curr.next = curr.next.next;
        return head;
    }
}
