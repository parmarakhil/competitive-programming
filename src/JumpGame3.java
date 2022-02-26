import java.util.Arrays;

public class JumpGame3 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] tp  = new int[n+1];
        Arrays.fill(tp, -1);
        return helper(0, n, nums, tp);
    }

    public boolean helper(int pos, int n, int[] arr, int[] tp){
        if(pos==n-1) return true;
        if(tp[pos]!=-1) return tp[pos]==1 ? true : false;
        int maxpos = Math.min(pos + arr[pos], n-1);
        for(int i=pos+1;i<=maxpos;i++){
            if(helper(i, n, arr, tp)){
                tp[pos] = 1;
                return true;
            }
        }
        tp[pos] = 0;
        return false;
    }
}
