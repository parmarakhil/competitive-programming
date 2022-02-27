import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();//create list

        for (int interval[] : intervals) {

            //case-> newInterval:null || Interval:[1,2] < newInteral[4,8]
            if (newInterval == null || interval[1] < newInterval[0])
                result.add(interval);

                //case-> newInterval:[3,10] > interval:[12,16]
            else if (newInterval[1] < interval[0]) {
                result.add(newInterval);
                result.add(interval);
                newInterval = null;

            }
            else { // otherwise change only newInterval's values
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        if (newInterval != null)  result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }
}
