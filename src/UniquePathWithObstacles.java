import java.util.Map;

public class UniquePathWithObstacles {
    public int uniquePathsWithObstacles(int[][] arr) {

        int m = arr.length;
        int n = arr[0].length;

        int[][] dp = new int[m][n];

        boolean block = false;
        for(int i = 0; i < m; i++){
            if(arr[i][0] == 1) block = true;

            if(!block) dp[i][0] = 1;
            else dp[i][0] = 0;
        }

        block = false;
        for(int i = 0; i < n; i++){
            if(arr[0][i] == 1) block = true;

            if(!block) dp[0][i] = 1;
            else dp[0][i] = 0;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(arr[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];

        //Map<String, Integer> m = new HashMap<>();
        //return helper(arr, arr.length, arr[0].length, m);
    }

    public int helper(int[][] arr, int m, int n, Map<String, Integer> hm){
        String s = m + "," + n;

        if(hm.containsKey(s)) return hm.get(s);

        if(m == 0 || n == 0){
            hm.put(s, 0);
        } else if(arr[m-1][n-1] == 1) {
            hm.put(s, 0);
        } else if(m == 1 && n == 1){
            if(arr[m-1][n-1] == 1){
                hm.put(s, 0);
            } else {
                hm.put(s, 1);
            }
        } else {
            hm.put(s, helper(arr, m-1, n, hm) + helper(arr, m, n-1, hm));
        }

        return hm.get(s);
    }
}
