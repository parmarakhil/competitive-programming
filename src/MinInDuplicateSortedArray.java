public class MinInDuplicateSortedArray {
    public int findMin(int[] nums) {
        int i = 0;

        for(int j=1; j<nums.length; j++)
        {
            if(nums[i] != nums[j])
            {
                nums[++i] = nums[j];
            }
        }

        int left = 0;
        int right = i;

        while(left <= right)
        {
            int mid = left + (right - left)/2;

            if(nums[mid] > nums[right])
                left++;
            else if(nums[mid] < nums[right])
                right--;
            else if(nums[mid] == nums[right] || nums[mid] == nums[left])
                return nums[mid];
            else
                break;
        }
        return -1;
    }
}
