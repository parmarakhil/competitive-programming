public class SwapNodePairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode swapped = new ListNode();
        ListNode temp = swapped;

        while (head != null && head.next != null) {

            ListNode first = head;
            ListNode second = first.next;
            ListNode third = second.next;

            second.next = first;
            first.next = third;

            temp.next = second;
            head = third;
            temp = temp.next.next;
        }

        return swapped.next;
    }
}
