public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head= l1.val<l2.val? l1:l2;
        ListNode l1pointer=l1.val<l2.val?l1.next:l1;
        ListNode l2pointer=l1.val<l2.val? l2:l2.next;
        ListNode temp=head;
        while(l1pointer!=null && l2pointer!=null){
            if(l1pointer.val<l2pointer.val){
                temp.next=l1pointer;
                l1pointer=l1pointer.next;
            }else{
                temp.next=l2pointer;
                l2pointer=l2pointer.next;
            }
            temp=temp.next;
        }
        temp.next= l1pointer!=null? l1pointer:l2pointer;
        return head;
    }
}
