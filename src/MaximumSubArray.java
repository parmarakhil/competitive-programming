public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int mxSum=Integer.MIN_VALUE;
        int curSum=0;
        for(int i=0;i<nums.length;i++){
            curSum+=nums[i];

            if(curSum>mxSum){
                mxSum=curSum;
            }

            if(curSum<0){
                curSum=0;
            }
        }
        return mxSum;
    }
}
