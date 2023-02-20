import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequence {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> a=new ArrayList<>();
        if(s.length()<=10){
            return a;
        }

        HashMap<String,Integer>map=new HashMap<>();
        for(int i=0;i<=s.length()-10;i++){
            String ans=s.substring(i,i+10);
            map.put(ans,map.getOrDefault(ans,0)+1);
        }

        for(Map.Entry<String,Integer>e:map.entrySet()){
            if(e.getValue()>1){
                a.add(e.getKey());
            }
        }
        return a;
    }
}
