public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0)
            return head;
        int len = 0;
        ListNode t = head;
        while(t!=null){
            len++;
            t=t.next;
        }

        if(len == 1)
            return head;
        k=k%len;
        if(k == 0)
            return head;

        ListNode temp = reverse(head);
        ListNode next = temp;
        ListNode prev =null;



        for(int i=0; i<k; i++){
            prev = next;
            next = next.next;
            if(next == null) //reset as k is greater than len
                next = temp;
        }

        if(next == null)
            return null;

        prev.next = null;
        ListNode firstHalf = reverse(temp);
        ListNode secondHalf = reverse(next);

        prev = null;
        temp = firstHalf;
        while(temp!=null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = secondHalf;
        return firstHalf;
    }

    ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode temp = head;

        while(temp!=null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}
