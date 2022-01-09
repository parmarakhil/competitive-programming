import java.util.HashMap;

public class LongestSubStringWithoutRepeatingCharacter {


    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1;
            }
            map.put(c, i);
            maxLength = Math.max(maxLength, (i - start + 1));
        }
        return maxLength;
    }
}
