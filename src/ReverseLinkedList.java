public class ReverseLinkedList {
    ListNode reverseList(ListNode head)
    {
        ListNode prev=null;
        ListNode Ne=null;
        ListNode cur=head;
        while(cur!=null)
        {
            Ne=cur.next;
            cur.next=prev;
            prev=cur;
            cur=Ne;
        }
        head=prev;
        return head;
    }
}
