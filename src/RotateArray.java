public class RotateArray {

    public int[] rotateArray(int[] nums, int k){
        int size= nums.length;
        int[] temp = new int[size];
        for(int i=0; i<size;i++){
            int m = (i+k)%size;
            temp[m]= nums[i];
        }
        for(int i=0; i<size;i++){
            nums[i]= temp[i];
        }
        return nums;
    }
}
