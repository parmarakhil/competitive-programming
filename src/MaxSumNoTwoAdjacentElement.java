public class MaxSumNoTwoAdjacentElement {

    // Function to find the maximum sum
    static int findMaxSum(int[] arr, int N)
    {
        // Declare dp array
        int[][] dp = new int[N][2];
        if (N == 1) {
            return arr[0];
        }

        // Initialize the values in dp array
        dp[0][0] = 0;
        dp[0][1] = arr[0];

        // Loop to find the maximum possible sum
        for (int i = 1; i < N; i++) {
            dp[i][1] = dp[i - 1][0] + arr[i];
            dp[i][0] = Math.max(dp[i - 1][1],
                    dp[i - 1][0]);
        }

        // Return the maximum sum
        return Math.max(dp[N - 1][0], dp[N - 1][1]);
    }
}
