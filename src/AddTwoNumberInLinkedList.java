import java.util.Stack;

public class AddTwoNumberInLinkedList {
    // To add two new numbers
    public static Node addTwoNumbers(Node l1, Node l2)
    {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null)
        {
            stack1.add(l1.data);
            l1 = l1.next;
        }

        while (l2 != null)
        {
            stack2.add(l2.data);
            l2 = l2.next;
        }

        int carry = 0;
        Node result = null;

        while (!stack1.isEmpty() ||
                !stack2.isEmpty())
        {
            int a = 0, b = 0;

            if (!stack1.isEmpty())
            {
                a = stack1.pop();
            }

            if (!stack2.isEmpty())
            {
                b = stack2.pop();
            }

            int total = a + b + carry;

            Node temp = new Node(total % 10);
            carry = total / 10;

            if (result == null)
            {
                result = temp;
            }
            else
            {
                temp.next = result;
                result = temp;
            }
        }

        if (carry != 0)
        {
            Node temp = new Node(carry);
            temp.next = result;
            result = temp;
        }
        return result;
    }


    public static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current!=null) {
            ListNode front = current.next;
            current.next = prev;
            prev = current;
            current = front;
        }
        return prev;
    }

    static void print(ListNode head) {
        ListNode temp= head;
        while (temp!=null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(9);


        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        ListNode answer = addTwoNumbers1(head, head1);
        print(answer);
    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode newHead = addNumbers(head1, head2);
        return reverse(newHead);
    }

    private static ListNode addNumbers(ListNode head1, ListNode head2) {
        ListNode head = new ListNode();
        ListNode current = head;
        int carry = 0;
        while (head1!=null || head2!=null) {
            int number = carry;
            if (head1!=null) {
                number+=head1.val;
                head1 = head1.next;
            }
            if (head2!=null) {
                number+=head2.val;
                head2 = head2.next;
            }
            carry = number/10;
            head.next = new ListNode(number%10);
            head = head.next;
        }
        if (carry!=0) {
            head.next = new ListNode(carry);
            head = head.next;
        }
        return current.next;

    }

    public static ListNode addTwoNumbers1(ListNode head1, ListNode head2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (head1!= null || head2!=null) {
            if (head1!=null) {
                stack1.push(head1.val);
                head1 = head1.next;
            }
            if (head2!=null) {
                stack2.push(head2.val);
                head2 = head2.next;
            }
        }
        int carry =0;
        ListNode head = new ListNode();;
        ListNode current = head;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int number = carry;
            if (!stack1.isEmpty()) {
                number+=stack1.pop();
            }
            if (!stack2.isEmpty()) {
                number+=stack2.pop();
            }
            carry = number/10;
            number = number%10;
            current.next= new ListNode(number);
            current = current.next;
        }
        if (carry != 0) {
            current.next= new ListNode(carry);
            current = current.next;
        }
        return reverse(head.next);
    }
}
