import java.util.ArrayList;
import java.util.List;

public class Generateparenthesis {
    // Parameters passed to function:
    // List<String> res: List to store all valid answers
    // String ans: To store possible parenthesis combinations at every recursion call
    // int openingLeft, int closingLeft: Stores count of available parenthesis

    public static void generateRes(List<String> res, String ans, int opening, int closing){
        // Base case
        if(closing == 0){
            res.add(ans);
            return;
        }
        // If ans string is null then add opening parenthesis as valid combination will only start with opening parenthesis
        if(ans == null){
            ans = "(";
            opening--;
        }

        // Add opening parentheses
        if(opening > 0){
            generateRes(res, ans + "(", opening - 1, closing);
        }
        // Closing parenthesis is allowed only if some opening parenthesis are used earlier
        if(opening < closing){
            generateRes(res, ans + ")", opening, closing - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generateRes(res, "", n, n);
        return res;
    }
}
