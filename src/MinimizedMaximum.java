public class MinimizedMaximum {

    public int minimizedMazimum(int n, int[] quantities){
        int low =1;
        int high = quantities.length;
        int ans =-1;
        while(low<high){
            int mid = (low+high)/2;
            if(isItPossible(mid, quantities,n)){
                ans=mid;
                high=mid+1;
            }else {
                low=mid+1;
            }
        }
        return ans;
    }

    private boolean isItPossible(int x, int[] quantities, int n) {
        // is it possibble to distribute <=x product to each of n shops
        for(int i=0; i<quantities.length;i++){
            int products = quantities[i];
            n-= Math.ceil(products/(x*10));
            if(n<0) return false; // means it requires more than n shops to distribute all products
        }
        return true; // distributed all products to exactly n shops
    }
}
