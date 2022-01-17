import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);

        int sum = 0;
        for(int i = 0; i < s.length(); i++){

            if((s.charAt(i) == 'I' || s.charAt(i) == 'X' || s.charAt(i) == 'C') && i < (s.length() - 1 )){

                String val = Character.toString(s.charAt(i)) + Character.toString(s.charAt(i+1));
                if(map.containsKey(val)){
                    sum = sum + map.get(val);
                    i++;
                }
                else{
                    sum = sum + map.get(Character.toString(s.charAt(i)));
                }
            }
            else{
                sum = sum + map.get(Character.toString(s.charAt(i)));
            }
        }

        return sum;
    }
}
