import java.util.Arrays;
import java.util.TreeMap;

public class MaxTip {
    /** Given 3 arrays called as Pickup, drop and tip
     * Find the max profit the delivery guy can earn.
     * The guy can only process one delivery at a time
     * */

    public static void main(String[] args) {
        long[] pickup = new long[] {0,2,9,10,11,12};
        long[] drop = new long[] {5,9,11,11,14,17};
        long[] tip = new long[]{1,2,3,2,2,1};

        System.out.println(calculateProfit(pickup,drop,tip));
    }

    public static long calculateProfit(long[] pickup, long[] drop, long[] tip){
        int n = pickup.length;
        long[][] d = new long[n][3];

        for(int i=0; i< n;i++)
            d[i] = new long[]{pickup[i], drop[i], calculateProfit(pickup[i], drop[i], tip[i])};
        Arrays.sort(d, (a,b) -> (int)a[1]-(int)b[1]);
        TreeMap<Long, Long> tm = new TreeMap<>();
        tm.put(0l,0l);
        for(long[] del:d){
            Long value = del[2]+tm.floorEntry(del[0]).getValue();
            if(value> tm.lastEntry().getValue()) tm.put(del[1], value);
        }
        return tm.lastEntry().getValue();
    }

    private static long calculateProfit(long pickup, long drop, long tip) {
        return (drop-pickup)+tip;
    }
}
