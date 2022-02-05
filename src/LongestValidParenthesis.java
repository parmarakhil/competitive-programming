import java.util.Stack;

public class LongestValidParenthesis {
    public int longestValidParentheses(String s) {
        Stack<Integer> parentheses = new Stack<>(){
            {
                push(-1);
            }
        };
        int result=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != '(' && parentheses.size()>1 && s.charAt(parentheses.peek())=='(')         {
                parentheses.pop();
                result = Math.max(result, i-parentheses.peek());
            }else
                parentheses.push(i);
        }

        return result;
    }
}
