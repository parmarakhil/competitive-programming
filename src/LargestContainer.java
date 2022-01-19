public class LargestContainer {
    public int maxArea(int[] height) {
        int res=0;
        //initialize left and right pointers to start with
        int left = 0;
        int right = height.length-1;

        while(left<right){
            //calculate area
            int area = (right-left)*Math.min(height[left],height[right]);
            res=Math.max(res,area);
            //main logic - move the pointer to cover higher point into the area set
            if(height[left]>height[right]){
                right--;
            }
            else{
                left++;
            }

        }

        return res;
    }
}
