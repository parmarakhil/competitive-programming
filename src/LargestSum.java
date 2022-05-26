public class LargestSum {
    /**
     * Returns sum of largest increasing subArray
     * */
    static int largestSum(int arr[], int n){
        int result = -999999;
        for(int i=0; i<n; i++){
            // Find sum of longest increasing subarray starting from arr[i]
            int currentSum = arr[i];
            while (i+1<n && arr[i+1]>arr[i]){
                currentSum+=arr[i+1];
                i++;
            }
            if(currentSum> result)  result= currentSum;
        }
        return result;
    }
}
