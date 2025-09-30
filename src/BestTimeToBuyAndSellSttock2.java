public class BestTimeToBuyAndSellSttock2 {

    public int bestTimeToBuyAndSellStock(int[] arr) {
        int index=0;
        int n = arr.length;
        return helper(arr, index, n, true);
    }

    public int helper(int[] arr, int index, int n, boolean buy) {
        if (index>=n) {
            return 0;
        }
        int profit=0;
        if (buy) {
            profit = Math.max(arr[index] + helper(arr, index+1, n, false), 0 + helper(arr, index+1, n, true));
        } else {
            profit = Math.max(arr[index] + helper(arr, index+1, n, true), 0 + helper(arr, index+1, n, false));
        }
        return profit;
    }

    public int bestTimeToBuyAndSellStock1(int[] arr) {
        int index=0;
        int n = arr.length;
        int[][] dp = new int[n][2];
        return helper1(arr, index, n, 0, dp);
    }

    public int helper1(int[] arr, int index, int n, int buy, int[][] dp) {
        if (index>=n) {
            return 0;
        }
        if (dp[index][buy]!=-1) return dp[index][buy];
        int profit=0;
        if (buy==0) {
            profit = Math.max(arr[index] + helper1(arr, index+1, n, 1, dp), 0 + helper1(arr, index+1, n, 0, dp));
        } else {
            profit = Math.max(arr[index] + helper1(arr, index+1, n, 0, dp), 0 + helper1(arr, index+1, n, 1, dp));
        }
        return dp[index][buy] = profit;
    }

    public int bestTimeToBuyAndSellStock3(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+2][2];
        dp[n][0]=0;
        dp[n][1]=0;
        for (int index=n-1; index>0; index--) {
            for (int buy=0; buy<=1; buy++) {
                int profit=0;
                if (buy==0) {
                    profit = Math.max(arr[index] + dp[index+1][1], 0 + dp[index+1][0]);
                } else {
                    profit = Math.max(arr[index] + dp[index+1][0], 0 + dp[index+1][1]);
                }
                dp[index][buy] = profit;
            }
        }
        return dp[0][1];
    }

    public int bestTimeToBuyAndSellStock4(int[] arr) {
        int n = arr.length;
        int[] next = new int[2];
        int[] prev= new int[2];
        next[0]=0;
        next[1]=0;
        for (int index=n-1; index>0; index--) {
            for (int buy=0; buy<=1; buy++) {
                int profit=0;
                if (buy==0) {
                    profit = Math.max(arr[index] + next[1], 0 + next[0]);
                } else {
                    profit = Math.max(arr[index] + next[0], 0 + next[1]);
                }
                prev[buy] = profit;
            }
            next = prev;
        }
        return next[1];
    }
}
