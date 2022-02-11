import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> output =new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backTrack(candidates,new ArrayList<Integer>(),0, target, output);
        return output;

    }

    public void backTrack(int[] candidates,List<Integer>  list, int index,int  target, List<List<Integer>> output){
        if(target==0) {
            output.add(new ArrayList<>(list));
            return;
        }
        if(target<0) return;
        for(int i=index;i<candidates.length;i++){
            if(i==index || candidates[i]!=candidates[i-1]){
                list.add(candidates[i]);
                backTrack(candidates,list,i+1, target-candidates[i], output);
                list.remove(list.size()-1);
            }
        }

    }
}
