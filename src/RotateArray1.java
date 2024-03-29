public class RotateArray1 {

    public void rotate(int[] nums, int k) {
        int rotation = k % nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, rotation-1);
        rotate(nums, rotation, nums.length - 1);
    }
    private void rotate(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
