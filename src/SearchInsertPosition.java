public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0) return 0;
        int output=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                output=i;
                break;
            }else if(nums[i]<target){
                output=i+1;
            }
        }
        return output;
    }
}
