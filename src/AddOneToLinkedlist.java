import java.util.Stack;

public class AddOneToLinkedlist {

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(9);
        ListNode answer1 = addOneToLinkedList1(head, 5);
        print(answer1);
//        ListNode answer = addOneToLinkedList2(head, 5);
//        print(answer);
    }

    static void print(ListNode head) {
        ListNode temp= head;
        while (temp!=null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println("");
    }


    public static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current!=null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    static int addWithCarry(ListNode head, int numberToAdd) {

        // If linked list is empty, return carry
        if (head == null) {
            return numberToAdd;
        }

        // Add carry returned by the next node call
        int res = head.val + addWithCarry(head.next, numberToAdd);

        // Update data and return new carry
        head.val = res % 10;
        return res / 10;
    }

    public static ListNode addOneToLinkedList1(ListNode head, int numberToAdd) {
        ListNode current = head;
        int carry = addWithCarry(current, numberToAdd);

        // If there is carry after updating all nodes,
        // then we need to add a new node to the linked list
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = current;

            // New node becomes head now
            return newNode;
        }
        return current;
    }

    public static ListNode addOneToLinkedList2(ListNode head, int numberToAdd) {
       head = reverse(head);
       head = addNumber(head, numberToAdd);
       return reverse(head);
    }

    public static ListNode addNumber(ListNode head, int numberToAdd) {
        ListNode current = head;
        ListNode node = null;
        int carry = 0 + numberToAdd;
        while (current!=null) {
            current.val = current.val + carry;
            if (current.val<10) {
                node = current;
                break;
            } else {
                carry = current.val/10;
                current.val = current.val%10;
                node = current;
                current = current.next;
            }
        }
        if (carry!=0) {
            node.next = new ListNode(carry);
        }
        return head;
    }
}
