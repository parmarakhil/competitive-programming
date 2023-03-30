import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParenthesis {
        public List<Integer> diffWaysToCompute(String expression) {
            ArrayList<Integer> ans = new ArrayList<Integer>();
            for(int i=0;i<expression.length();i++)
            {
                if(expression.charAt(i)=='+'||expression.charAt(i)=='*'||expression.charAt(i)=='-')
                {
                    List<Integer> ans1 =  diffWaysToCompute(expression.substring(0,i));
                    List<Integer> ans2 =  diffWaysToCompute(expression.substring(i+1));
                    for(int j=0;j<ans1.size();j++)
                    {
                        for(int k=0;k<ans2.size();k++)
                        {
                            if(expression.charAt(i)=='+')
                                ans.add(ans1.get(j)+ans2.get(k));
                            else  if(expression.charAt(i)=='*')
                                ans.add(ans1.get(j)*ans2.get(k));
                            else
                                ans.add(ans1.get(j)-ans2.get(k));
                        }
                    }

                }
            }
            if(ans.size()==0)
                ans.add(Integer.parseInt(expression));
            return ans;
        }
}
