import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
        if(s.length()%2==1)
            return false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.empty())
                    return false;
                else{
                    char current=stack.pop();
                    if(current=='(' && s.charAt(i)!=')')
                        return false;
                    if(current=='[' && s.charAt(i)!=']')
                        return false;
                    if(current=='{' && s.charAt(i)!='}')
                        return false;
                }
            }
        }
        return stack.empty();

    }
}
