import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CountAnargams1 {

    // giver two arrays arr1[] and arr2[] consisting of strings, the task is to print the count of anagrams of every string in arr2[] that are present in arr1[].
    public static void main(String[] args) {
        String[] arr1 = new String[]{"geeks", "learn", "for", "egeks", "ealrn"};
        String[] arr2 = new String[]{"kgees", "rof", "nrael"};
        countAnargams1(arr1, arr2);
    }

    public static  void countAnargams(String arr1[], String arr2[]) {
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        for (String s: arr1) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            frequencyMap.put(temp, frequencyMap.getOrDefault(temp, 0)+1);
        }
        for (String s: arr2) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            int count =frequencyMap.get(temp);
            System.out.println(count + "\n");
        }
    }

    public static  void countAnargams1(String arr1[], String arr2[]) {
        for (int i =0; i< arr2.length; i++) {
            int count =count(arr2[i], arr1);
            System.out.println(count + "\n");
        }
    }

    private static int count(String s, String[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (checkAnagram(s, arr[i]))
                count++;
        }
        return count;
    }

    public static void calculateFrequency(String str, int[] freq) {
        for (int i = 0; i < str.length(); i++)
            freq[str.charAt(i) - 'a']++;
    }

    // Function to check if two strings are anagrams of each other
    public static boolean checkAnagram(String str1, String str2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        calculateFrequency(str1, freq1);
        calculateFrequency(str2, freq2);
        return Arrays.equals(freq1, freq2);
    }
}
