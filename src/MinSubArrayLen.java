public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int low=1;
        int high=nums.length+1;
        boolean flag=false;
        while(low<high){
            int mid=low+(high-low)/2;
            if(fixsw(mid,nums,target)==true){
                flag=true;
                high=mid;
            }
            else
                low=mid+1;
        }
        if(!flag)
            return 0;
        return low;
    }
    public boolean fixsw(int size,int[] nums,int target){
        int i=0;
        int j=0;
        int sum=0;
        int max=Integer.MIN_VALUE;
        while(j<nums.length){
            sum+=nums[j];
            if(j-i+1==size){
                max=Math.max(max,sum);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        if(max>=target){
            return true;
        }
        return false;
    }
}
