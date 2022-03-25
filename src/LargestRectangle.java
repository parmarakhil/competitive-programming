public class LargestRectangle {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int[] lessOnLeft = new int[heights.length]; // record first idx on the left that heights[idx] is less than heights[i];
        int[] lessOnRight = new int[heights.length]; // record first idx on the right that heights[idx] is less than heights[i];
        // then recArea = heights[i] * (lessOnRight[i] - lessOnLeft[i] - 1) (exclude two ends)

        lessOnLeft[0] = -1;
        lessOnRight[heights.length - 1] = heights.length;

        for (int i = 1; i < heights.length; i++){
            // continuously find the lessOnLeft of the lessOnLeft ...
            // until heights[lessOnLeft] < heights[i];
            int idx = i - 1;
            while (idx >= 0 && heights[idx] >= heights[i]){
                idx = lessOnLeft[idx];
            }
            lessOnLeft[i] = idx;
        }

        for (int i = heights.length - 2; i >= 0; i--){
            int idx = i + 1;
            while (idx < heights.length && heights[idx] >= heights[i]){
                idx = lessOnRight[idx];
            }
            lessOnRight[i] = idx;
        }

        // for each rectangle of width heights[i], do the calc
        int result = 0;
        for (int i = 0; i < heights.length; i++){
            result = Math.max(result, heights[i] * (lessOnRight[i] - lessOnLeft[i] - 1));
        }
        return result;

    }
}
