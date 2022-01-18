import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int low=i+1;
            int high= nums.length-1;
            int sum=0-nums[i];
            while(low<high){
                if(nums[low]+nums[high]== sum) {
                    set.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                }
                else if(nums[low]+nums[high] < sum) low++;
                else high--;
            }
        }
        return new ArrayList(set);
    }
}
