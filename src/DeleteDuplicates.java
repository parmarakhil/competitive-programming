public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        //If duplicates found
        if(head.val==head.next.val){
            int val=head.val;
            while(head!=null && head.val==val) //loop till all the duplicates are removed
                head=head.next;
            return deleteDuplicates(head); //go to next recursion call
        }
        //Executes when current node is not a duplicate
        head.next=deleteDuplicates(head.next);
        return head;
    }
}
