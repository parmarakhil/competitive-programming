import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnargamStringSearch {

    // Brute force approach is to generate all substring of s and sort them before storing. sort p and then compare if all substring of s is equal to sorted p


    // optimised approach.
    // we know that for an anargram the length of strings should be same and frequency of objects should be same so we will leverage that
    public List<Integer> anargamStringSearch(String s, String p) {
        List<Integer> answer = new ArrayList<>();
        // if p is greater than s then anargram is not possible
        if (s.length()<p.length()) return answer;
        int[] sFrequency = new int[26];
        int[] pFrequency = new int[26];
        int n = s.length();
        int m = p.length();
        // first window i.e. 0 -> m
        for (int i=0; i<m; i++) {
            sFrequency[s.charAt(i)-'a']++;
            pFrequency[p.charAt(i)-'a']++;
        }
        // if start of s is itself an anargram
        if (Arrays.equals(pFrequency, sFrequency)) {
            answer.add(0);
        }
        // additional substrings
        // we start with m as we have already checked from 0 ->m
        for (int i=m; i<n; i++) {
            // we would add 1 element of s which is at i position and also remove the last first/initial element as we want to maintain the constant window
            sFrequency[s.charAt(i)-'a']++;
            sFrequency[s.charAt(i-m)-'a']--;
            if (Arrays.equals(pFrequency, sFrequency)) {
                answer.add(i-m+1);
            }
        }
        return answer;


    }
}
