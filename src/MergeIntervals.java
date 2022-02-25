import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int[] prev = intervals[0];
        result.add(prev);
        for(int i=1; i<intervals.length; i++) {
            int[] curr = intervals[i];
            if(curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                prev = curr;
                result.add(prev);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
