public class Pow {
    /**
     * Reduce N by half in every recursion
     *
     * Time Complexity: O(log N)
     *
     * Space Complexity: O(log N) - Space required by recursion stack.
     *
     * N = Input number n.
     */
        public double myPow(double x, int n) {
            if(n<0){
                x=1/x;
                if(n==Integer.MIN_VALUE){
                    if(x==1 || x==-1)
                        return 1;
                    else
                        return 0;
                }
            }
            return func(x,Math.abs(n));
        }
        public double func(double x,int n){
            if(n==0)
                return 1;

            double xpnb2=func(x,n/2);
            double xn=xpnb2*xpnb2;

            if(n%2==1)
                xn=xn*x;

            return xn;
        }
}
