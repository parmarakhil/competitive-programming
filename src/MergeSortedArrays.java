public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length-1;

        m-=1;
        n-=1;

        // Putting next greatest element at last index
        while (m >= 0 && n >= 0) {
            if(nums2[n]>nums1[m]){
                nums1[index--] = nums2[n--];
            }else if(nums2[n] == nums1[m]){
                nums1[index--] = nums2[n--];
                nums1[index--] = nums1[m--];
            }else{
                nums1[index--] = nums1[m--];
            }
        }

        // coping left over elements
        while (m >= 0) {
            nums1[index--] = nums1[m--];
        }
        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }
    }
}
