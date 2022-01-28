public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int length=0;
        int k=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==val){
                continue;
            }

            else
            {
                nums[k]=nums[i];
                k++;
                length++;
            }
        }
        return length;
    }
}
