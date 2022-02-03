import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> output = new ArrayList<>();
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        // Store each word and their number of occurrences for quick lookup.
        for (String word : words) {
            int val = wordCountMap.getOrDefault(word, 0);
            wordCountMap.put(word, val + 1);
        }
        // Find substrings with size equal to length of all words concatenated.
        // Only consider those substrings that start with one of the words.
        int totalWords = words.length;
        int commonLength = words[0].length();
        // For each word, find the indexes within the given string.
        for (String word : wordCountMap.keySet()) {
            int index = 0;
            while (true) {
                index = s.indexOf(word, index);
                boolean matchFound = true;
                if (index != -1) {
                    if (index + totalWords * commonLength <= s.length()) {
                        String candidateSubstr = s.substring(index, index + totalWords * commonLength);
                        // All words are of same length.
                        // Divide candidate substring into small chunks of size equal to common word length.
                        // Check if chunk is a valid word, store chunk and number of occurrences of chunk
                        // in candidate substring.
                        HashMap<String, Integer> candidateWordCountMap = new HashMap<>();
                        for (int startIndex = 0; startIndex < candidateSubstr.length(); startIndex += commonLength) {
                            String subStr = candidateSubstr.substring(startIndex, startIndex + commonLength);
                            if (!wordCountMap.containsKey(subStr)) {
                                matchFound = false;
                                break;
                            }
                            int val = candidateWordCountMap.getOrDefault(subStr, 0);
                            candidateWordCountMap.put(subStr, val + 1);
                        }
                        // Verify that words in candidate substring and number of occurrences match with the
                        // initial dictionary created.
                        if (matchFound) {
                            for (String w : wordCountMap.keySet()) {
                                if (candidateWordCountMap.get(w) == null ||
                                        candidateWordCountMap.get(w).intValue() != wordCountMap.get(w).intValue()) {
                                    matchFound = false;
                                    break;
                                }
                            }
                        }
                        // Include index as part of result if all conditions match.
                        if (matchFound) {
                            output.add(index);
                        }
                    }
                    index += 1;
                } else {
                    break;
                }
            }
        }
        return output;
    }
}
