import java.util.ArrayList;
import java.util.List;

public class PalindromePartinitoning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> subSeq = new ArrayList<>();
        subSequence(s , ans , subSeq);
        return ans;
    }

    public void subSequence(String s ,  List<List<String>> ans , List<String> subSeq)
    {
        if(s == "")
        {
            ans.add(new ArrayList(subSeq));
            return;
        }

        String str = "";
        for(int i = 0 ; i < s.length() ; i++){
            str+=s.charAt(i);
            if(isPalin(str)){
                subSeq.add(str);
                subSequence(s.substring(i+1) , ans , subSeq);
                subSeq.remove(subSeq.size()-1);
            }
        }
    }

    public boolean isPalin(String s){
        int len = s.length()-1;
        int i = 0;

        while(i<=len)
        {
            if(s.charAt(i)!=s.charAt(len))
                return false;
            len--;
            i++;
        }
        return true;
    }
}
