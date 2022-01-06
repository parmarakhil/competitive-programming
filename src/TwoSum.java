import java.util.HashMap;
import java.util.Map;

class TwoSum{
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> temp=new HashMap<>();
        for(int i=0; i<nums.length;i++){
            temp.put(nums[i],i);
        }
        for(int i=0; i<nums.length;i++){
            if(temp.containsKey(target-nums[i]) && i!= temp.get(target-nums[i]) ){
                return new int[]{i, temp.get(target-nums[i])};
            }
        }
        return new int[2];
    }
}