import java.util.*;

public class GroupAnargam {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>() ;
        Map<String,List<String>> map = new HashMap<>() ;
        for(String strings : strs){
            char ch[] = strings.toCharArray() ;
            Arrays.sort(ch) ;
            String st = new String(ch);
            if(!map.containsKey(st)){
                map.put(st , new ArrayList<>()) ;
            }
            map.get(st).add(strings) ;
        }
        for(String key : map.keySet()){
            List<String> lis = new ArrayList<>(map.get(key)) ;
            list.add(lis) ;
        }
        return list ;
    }
}
