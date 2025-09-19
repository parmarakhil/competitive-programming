public class AddTwoNumberInLinkedListReverse {

    public static void main(String[] args) {

        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(9);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next = new ListNode(9);


        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(9);
        head1.next.next = new ListNode(9);
        head1.next.next.next = new ListNode(9);
        ListNode answer = addTwoNumbers(head, head1);
        print(answer);
    }

    static void print(ListNode head) {
        ListNode temp= head;
        while (temp!=null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode head = new ListNode();
        ListNode current = head;
        int carry = 0;
        while (head1!=null || head2!=null) {
            int number = carry;
            if ((head1!=null)) {
                number += head1.val;
                head1 = head1.next;
            }
            if (head2!=null) {
                number += head2.val;
                head2 = head2.next;
            }
            carry = number/10;
            number = number%10;
            current.next = new ListNode(number);
            current = current.next;
        }
        if (carry!=0) {
            current.next = new ListNode(carry);
            current = current.next;
        }
        return head.next;
    }

}
