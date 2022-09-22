public class SmallestDuplicateKtimes {


    static final int MAX = 1000;

    // finds the smallest number in arr[]
    // that is repeated k times
    static int findDuplicate(int arr[], int n, int k)
    {
        // Computing frequencies of all elements
        int[] freq = new int[MAX];

        for (int i = 0; i < n; i++) {
            if (arr[i] < 1 && arr[i] > MAX) {
                System.out.println("Out of range");
                return -1;
            }
            freq[arr[i]] += 1;
        }

        // Finding the smallest element with
        // frequency as k
        for (int i = 0; i < MAX; i++) {

            // If frequency of any of the number
            // is equal to k starting from 0
            // then return the number
            if (freq[i] == k)
                return i;
        }

        return -1;
    }


}
