public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        int slow = 0; // points to the latest valid item, first item is always valid
        int count = 1; // count is one
        for(int i = 1; i< nums.length; i ++) {
            if(nums[i] != nums[i-1]) {
                count = 1;
                slow ++; // move to the first invalid item
                nums[slow] = nums[i];
            } else {
                if (count < 2) { // when count is less than 2, it is still valid
                    count ++;

                    slow ++; // again, move to the first invalid item
                    nums[slow] = nums[i];
                }
            }
        }

        return slow + 1;
    }
}
