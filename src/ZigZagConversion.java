import java.util.HashMap;
import java.util.Map;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }
    public static String convert(String s, int numRows) {
        Map<Integer,String> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            int index=i%numRows;
            char char1=s.charAt(index);
            map.put(i%numRows, map.getOrDefault(i%numRows,"")+s.charAt(i));
        }
        String output="";
        for(int i=0;i<numRows;i++){
            output+=map.get(i);
        }
        return output;
    }

}
