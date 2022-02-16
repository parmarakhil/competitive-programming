public class JumpGame2 {
    public int jump(int[] nums) {
        int n = nums.length-1;
        int jumpValue = nums[0];
        int jumpIndex = 0;
        int count=0;
        if ((n == 0) || (n+1 == 0)){
            return count;
        }
        while (jumpIndex < n+1){
            if (jumpIndex + jumpValue >= n){
                return count+1;
            }
            int k = jumpIndex;
            int l = jumpValue;
            for (int i = k; i <= k + l && i < n+1 ; i++){
                if (jumpValue + jumpIndex <= nums[i] + i){
                    jumpValue = nums[i];
                    jumpIndex = i;
                }
            }
            count++;
        }
        return count+1;
    }
}
