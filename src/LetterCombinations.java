import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<String>();
        }
        return helper(digits);
    }

    public List<String> helper(String digits)
    {
        List<String> result=new ArrayList<String>();
        if(digits.length()==0){
            result.add("");
            return result;
        }

        List<String> subRes=helper(digits.substring(1));
        String[] indexRes=keypad(digits.charAt(0)-'0');
        for(int i=0;i<subRes.size();i++)
        {
            for(int j=0;j<indexRes.length;j++)
            {
                result.add(indexRes[j]+subRes.get(i));
            }
        }
        return result;
    }
    public String[] keypad(int data)
    {
        if(data<=1 || data>9)
        {
            return new String[0];
        }
        else if(data==2)
        {
            return new String []{"a","b","c"};
        }
        else if(data==3)
        {
            return new String []{"d","e","f"};
        }
        else if(data==4)
        {
            return new String []{"g","h","i"};
        }
        else if(data==5)
        {
            return new String []{"j","k","l"};
        }
        else if(data==6)
        {
            return new String []{"m","n","o"};
        }
        else if(data==7)
        {
            return new String []{"p","q","r","s"};
        }
        else if(data==8)
        {
            return new String []{"t","u","v"};
        }
        else
        {
            return new String []{"w","x","y","z"};
        }
    }
}
