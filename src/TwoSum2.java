public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length-1;
        while(low<high){
            int diff = target-numbers[low];
            if (diff==numbers[high]) {
                return new int[]{low+1,high+1};
            }
            else if (diff<numbers[high]) {
                high--;
            }
            else low++;
        }
        return null;

    }
}
