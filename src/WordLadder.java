import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        // IF THE END WORD DOESN'T EXIST
        if(!set.contains(endWord))
            return 0;

        // PERFORM A BFS LEVEL-BY-LEVEL
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        int wordLen = beginWord.length();

        // EXPLORE UNTIL THE QUEUE IS EMPTY
        while(!queue.isEmpty()){
            int qSize = queue.size();
            // CHECK FOR ALL WORDS IN THE CURRENT LEVEL
            for(int i=0; i < qSize; i++){
                char[] currWord = queue.poll().toCharArray();
                // EXPLORE ALL POSSIBLE COMBINATIONS BY MODIFYING A SINGLE CHARACTER IN THE CURRENT WORD AT EACH POSITION FROM [a..z]
                for(int j=0; j < wordLen; j++){
                    char temp = currWord[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        currWord[j] = c;
                        String nextWord = new String(currWord);

                        // IF THE MODIFIED WORD IS AVAILABLE IN THE SET, THEN THAT COULD BE ADDED IN QUEUE FOR EXPLORATION IN THE NEXT LEVEL
                        if(set.contains(nextWord)){
                            // IF WE HAVE FOUND THE END WORD THEN WE RETURN AFTER UPDATING THE LEVEL
                            if(nextWord.equals(endWord))
                                return level + 1;
                            queue.add(nextWord);
                            set.remove(nextWord);
                        }
                        // RESET THE CURRENT WORD BACK TO ORIGINAL FORM BEFORE NEXT EXPLORATION
                        currWord[j] = temp;
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
