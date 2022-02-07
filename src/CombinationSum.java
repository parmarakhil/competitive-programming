import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0;i<candidates.length;i++){
            ArrayList<Integer> a = new ArrayList<>();
            a.add(candidates[i]);
            helper(a,target-candidates[i],candidates,i,ans);
        }

        return ans;
    }

    public void helper(ArrayList<Integer> a,int tar,int[] c,int k,List<List<Integer>> ans){
        if(tar <=0){
            if(tar == 0){
                System.out.println("==>" + a);
                ans.add(new ArrayList<>(a));
            }

            return;
        }

        for(int i = k;i<c.length;i++){
            a.add(c[i]);
            //System.out.println(a);
            helper(a,tar-c[i],c,i,ans);
            a.remove(a.size()-1);
        }
    }
}
