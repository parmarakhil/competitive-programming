public class InterLeavingStrings {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null) return false;
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if(len1 + len2 != len3) return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        char[] s3Char = s3.toCharArray();
        dp[0][0] = true;
        for(int i = 1; i <= len1; i++){
            dp[i][0] = dp[i - 1][0] && (s3Char[i - 1] == s1.charAt(i - 1));
        }
        for(int i = 1; i <= len2; i++){
            dp[0][i] = dp[0][i - 1] && (s3Char[i - 1] == s2.charAt(i - 1));
        }
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                dp[i][j] = (dp[i][j - 1] && (s3Char[i + j - 1] == s2.charAt(j - 1)))
                        || (dp[i - 1][j] && (s3Char[i + j - 1] == s1.charAt(i - 1)));
            }
        }
        return dp[len1][len2];
    }
}
