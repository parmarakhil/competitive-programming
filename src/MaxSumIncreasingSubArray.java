public class MaxSumIncreasingSubArray {

    static int maxsumSIS(int arr[], int n){

        int maxSum = arr[0];
        int currentSum = arr[0];

        for(int i=1;i<n;i++){
            if(arr[i-1]<arr[i]){
                currentSum +=arr[i];
                maxSum = Math.max(maxSum, currentSum);
            }else{
                maxSum=Math.max(maxSum,currentSum);
                currentSum=arr[i];
            }
        }
        return Math.max(maxSum,currentSum);
    }
}
