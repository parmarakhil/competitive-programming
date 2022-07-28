public class ReorderLinkedList {
    public ListNode reverse( ListNode head ){
        ListNode prev = null ;
        ListNode curr = head ;
        while (curr != null ){
            ListNode temp = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = temp ;

        }
        head = prev ;
        return head ;
    }

    public void reorderList(ListNode head) {
        ListNode slow = head ;
        ListNode fast = head ;
        while(fast != null && fast.next != null){              //FINDING MID BY TURTLE AND HAIRE
            slow = slow.next ;                                        //
            fast = fast.next.next ;                                 //
        }                                                                  //
        ListNode temp = slow.next ;
        slow.next = null ;
        temp = reverse(temp) ;
        ListNode prev = head ;
        ListNode curr = prev.next ;
        ListNode p = null ;
        while( curr != null && curr.next != null ) {
            p = temp ;                                                //MERGING ORIGINAL WITH REVERSED LIST
            temp = temp.next ;
            p.next = curr ;
            prev.next = p ;
            prev = curr ;
            curr = curr.next ;
        }
        if(temp != null){
            prev.next = temp ;
            temp.next = curr ;
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
