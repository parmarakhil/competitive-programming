public class ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res =0;
        for(int i =0;i<32;i++) {
            //this is used to find least significant digit (lsb)
            // 00000010100101000001111010011100 & 1 = 00000010100101000001111010011100<- lsb =0
            int lsb = n & 1;

            // soo, left shift of lsb lsb<<(31-i) so our 1st position zero will swaped with 31-i.so on...
            int revLsb = lsb<<(31-i);
            // store the revLsb in our result variable
            res = res|revLsb;

            // right sift of n , one time ans soo on...
            n= n>>1;
        }
        return res;
    }
}
