import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {

        int[] coins = new int[]{1,2,5};
        int target  =11;
        int n = coins.length;
        System.out.println(coinChange(coins, target, n-1));
        int[][] dp = new int[n][target+1];
        System.out.println(coinChange1(coins, target, n-1,  dp));
        System.out.println(coinChange2(coins, target, n,  dp));
        System.out.println(coinChange3(coins, target, n));
    }


    // recursion
    public static int coinChange(int[] coins, int target, int index) {
        if (index==0) {
            if (target%coins[0]==0) {
                return target/coins[0];
            }
            return Integer.MAX_VALUE;
        }

        int take = Integer.MAX_VALUE;
        if (coins[index]<=target) {
            take = 1 + coinChange(coins, target-coins[index], index);
        }
        int notTake = coinChange(coins, target, index-1);
        return Math.min(take, notTake);
    }

    // memoiaztion
    public static int coinChange1(int[] coins, int target, int index, int[][] dp) {
        if (index==0) {
            if (target%coins[0]==0) {
                return target/coins[0];
            }
            return Integer.MAX_VALUE;
        }

        if (dp[index][target] ==-1) {
            return dp[index][target];
        }
        int take = Integer.MAX_VALUE;
        if (coins[index]<=target) {
            take = 1 + coinChange1(coins, target-coins[index], index, dp);
        }
        int notTake = coinChange1(coins, target, index-1, dp);
        return dp[index][target]=Math.min(take, notTake);
    }

    // tabulation
    public static int coinChange2(int[] coins, int target, int n, int[][] dp) {
        for (int T=0; T<=target; T++) {
            if (T%coins[0]==0) {
                dp[0][T]=T/coins[0];
            } else {
                dp[0][T]=Integer.MAX_VALUE;
            }
        }

        for (int ind=1; ind<n; ind++) {
            for (int T=0; T<=target; T++) {
                int take = Integer.MAX_VALUE;
                if (coins[ind]<=T) {
                    take = 1 + dp[ind][T-coins[ind]];
                }
                int notTake = dp[ind-1][T];
                dp[ind][T]=Math.min(take, notTake);
            }
        }
        return dp[n-1][target];
    }

    // space optimisation
    public static int coinChange3(int[] coins, int target, int n) {
        int[] previous = new int[target+1];
        int[] current = new int[target+1];
        for (int T=0; T<=target; T++) {
            if (T%coins[0]==0) {
                previous[T] = T/coins[0];
            } else {
                previous[T] = Integer.MAX_VALUE;
            }
        }

        for (int ind=1; ind<n; ind++) {
            for (int T=0; T<=target; T++) {
                int take = Integer.MAX_VALUE;
                if (coins[ind]<=T) {
                    take = 1 + current[T-coins[ind]];
                }
                int notTake = previous[T];
                current[T]=Math.min(take, notTake);
            }
            previous = current;
        }
        return previous[target];
    }
}
