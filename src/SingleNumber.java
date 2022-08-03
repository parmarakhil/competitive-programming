public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++)
            ans^=nums[i];  // as a^a=0 ans a^0=a
        return ans;
    }
}
