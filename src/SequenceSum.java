/**
 * given 3 integers i,j,k
 * return the sum of all numbers starting from i till j in increament order
 * then add all numbers from j till k in decrement order*/
public class SequenceSum {
    //0,5,-1
    static long sequenceSum(int i, int j, int k){
        long sum=0;
        for(int p=i;p<j;p++){
            sum+=p;
        }
        for(int p=j;p>k;p--){
            sum+=p-1;
        }
        return sum;
    }
}
