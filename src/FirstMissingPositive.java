public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length, INF = n + 1;

        for (int i = 0; i < n; i++)
            if (nums[i] <= 0)
                nums[i] = INF; // marks zero or negative numbers as infinitive positive numbers

        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums[i]) - 1; // use index start with zero
            if (x < n)
                nums[x] = -Math.abs(nums[x]); // mark `x` as visited by marking `nums[x]` as negative
        }

        for (int i = 0; i < n; i++)
            if (nums[i] > 0) // if nums[i] is positive -> number (i+1) is not visited.
                return i + 1;
        return n + 1;

    }
}
