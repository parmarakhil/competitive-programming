public class LongestPallindrome {
    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        int len=0, len1=0, len2=0, start=0, end=0;
        for(int i = 0;i < s.length(); i++) {
            len1 = expandFromMiddle(s,i,i);
            len2 = expandFromMiddle(s,i,i+1);
            len = Math.max(len1, len2);
            if(len > end-start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }
    public int expandFromMiddle(String s, int left, int right) {
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right-1-left;
    }
}
