public class CompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        long sum = 0;
        int maxLoc = 0, max = 0, minLoc = 0, min = 0;
        int startMax = 0, endMin = 0, newStartMax = 0;
        for (int i = 0; i < gas.length; ++i) {
            int diff = gas[i] - cost[i];
            sum += diff;
            // Get max subarray sum
            if (maxLoc + diff < 0) {
                maxLoc = 0;
                newStartMax = -1;
            } else {
                if (newStartMax == -1)
                    newStartMax = i;
                maxLoc += diff;
            }
            if (max < maxLoc) {
                max = maxLoc;
                startMax = newStartMax;
            }

            // Get min subarray sum
            minLoc = Math.min(0, minLoc + diff);
            if (min > minLoc) { min = minLoc; endMin = i; }
        }
        if (sum < 0)
            return -1;
        if (sum - min > max)
            return endMin + 1;
        return startMax;
    }
}
