import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> output=new HashSet<>();
        for(int i=0;i<nums.length-3;i++){
            for(int k=i+1;k<nums.length-2;k++){
                int low=k+1;
                int high=nums.length-1;
                while(low<high){
                    if(nums[low]+nums[high]== target-nums[i]-nums[k]){
                        output.add(Arrays.asList(nums[i],nums[k],nums[low],nums[high]));
                        low++;
                        high--;
                    }else if(nums[low]+nums[high] < target-nums[i]-nums[k]) low++;
                    else high--;
                }
            }

        }
        return new ArrayList<>(output);
    }
}
