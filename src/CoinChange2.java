import java.lang.annotation.Target;
import java.util.Arrays;

public class CoinChange2 {

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int target = 11;
        System.out.println(coinChange(coins, target));
        System.out.println(coinChange1(coins, target));
        System.out.println(coinChange2(coins, target));
    }

    // given coins and target return the number of combinations the target can be achieved
    public static int coinChange(int[] coins, int target) {
        return calculateChange(coins, target, coins.length-1);
    }

    public static int coinChange1(int[] coins, int target) {
        int[][] dp = new int[coins.length][target+1];
        for (int[] sub: dp) {
            Arrays.fill(sub, -1);
        }
        return calculateChange1(coins, target, coins.length-1, dp);
    }

    public static int coinChange2(int[] coins, int target) {
        int[][] dp = new int[coins.length][target+1];
        return calculateChange2(coins, target, coins.length-1, dp);
    }


    // recursion
    public static int calculateChange(int[] coins, int target, int index) {
        if (index==0) {
            return target % coins[0]==0 ? 1 : 0;
        }
        int take = 0;
        if (target>=coins[index]) {
            take = calculateChange(coins, target - coins[index], index);
        }
        int notTake = calculateChange(coins, target, index-1);
        return take + notTake;
    }

    // memoization
    public static int calculateChange1(int[] coins, int target, int index, int[][] dp) {
        if (index==0) {
            return target % coins[0]==0 ? 1 : 0;
        }
        if (dp[index][target]!=-1) return dp[index][target];
        int take = 0;
        if (target>=coins[index]) {
            take = calculateChange1(coins, target - coins[index], index, dp);
        }
        int notTake = calculateChange1(coins, target, index-1, dp);
        return dp[index][target] = take + notTake;
    }

    // tabulation
    public static int calculateChange2(int[] coins, int target, int index, int[][] dp) {
        for (int T=0; T<=target; T++) {
            if (T%coins[0]==0) {
                dp[0][T] = 1;
            } else {
                dp[0][T] = 0;
            }
        }
        for (int ind =1; ind<=index; ind++) {
            for (int T=0; T<=target; T++) {
                int take = 0;
                if (coins[ind]<=T) {
                    take = dp[ind][T - coins[ind]];
                }
                int notTake = dp[ind-1][T];
                dp[ind][T] = take + notTake;
            }
        }
        return dp[index][target];
    }
}
