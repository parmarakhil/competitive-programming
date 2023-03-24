import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsPallindromeLinkedlist {

    public boolean isPalindrome(ListNode head) {
        Queue<Integer> q = new LinkedList<Integer>();
        Stack<Integer> s = new Stack<Integer>();
        while(head != null) {
            q.add(head.val);
            s.push(head.val);
            head = head.next;
        }

        while(!s.isEmpty()) {
            if(q.remove() != s.pop()) {
                return false;
            }
        }

        return true;

    }
}
