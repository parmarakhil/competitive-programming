public class BestTimeToBuyAndSellStock {

    public int bestTimeToBuyAndSellStock(int[] arr) {
        int min=arr[0], profit=0;
        for (int i=1; i<arr.length; i++) {
            int cost = arr[i]-min;
            profit = Math.max(cost, profit);
            min = Math.min(min, arr[i]);
        }
        return profit;
    }
}
