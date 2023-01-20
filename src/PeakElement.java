public class PeakElement {
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, nums.length - 1);
    }

    public int binarySearch(int[] arr, int n) {
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid == 0) {
                if(arr[mid] > arr[mid + 1]) {
                    return mid;
                }
            }
            if (mid == n) {
                if (arr[mid] >= arr[mid - 1]) {
                    return mid;
                }
            }
            if (arr[mid] > arr[mid + 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return start;
    }
}
