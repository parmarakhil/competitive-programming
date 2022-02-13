public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;

        //return extraSpace(height);
        return noExtraSpace(height);
    }

    private int noExtraSpace(int[] height) {
        int left = 0; int right = height.length-1;
        int result = 0;
        int maxLeft = height[left];
        int maxRight = height[right];
        while (left < right) {
            if (maxLeft <= maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                result += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                result += maxRight - height[right];
            }
        }
        return result;
    }


    private int extraSpace(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int i=1;i<height.length;i++) left[i] = Math.max(left[i-1], height[i-1]);
        for (int i=height.length-2;i>=0;i--) right[i] = Math.max(right[i+1], height[i+1]);

        int result = 0;

        for (int i=0;i<height.length;i++) {
            int min = Math.min(left[i], right[i]);
            if (min >= height[i]) result += min-height[i];
        }

        return result;
    }
}
