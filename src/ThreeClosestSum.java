import java.util.Arrays;

public class ThreeClosestSum {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int size = nums.length;
        long closest = Integer.MAX_VALUE;
        for(int i=0;i<size-2;i++){
            int low = i+1, high= size-1;
            while(low<high){
                long sum = nums[i]+nums[low]+nums[high];
                if(Math.abs(target-sum) < Math.abs(target-closest))
                    closest = sum;

                if(sum<target)
                    low++;
                else
                    high--;
            }
        }
        return (int)closest;
    }
}
