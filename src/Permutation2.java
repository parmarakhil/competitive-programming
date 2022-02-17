import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ll=new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> al=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        helper(nums,visited,ll,al,0);
        return ll;
    }
    private void helper(int nums[],boolean visited[],List<List<Integer>> ll,List<Integer> al,int c){
        if(c==nums.length){
            List<Integer> temp=new ArrayList<>(al);
            ll.add(temp);
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                if(i>0&&nums[i]==nums[i-1]&&!visited[i-1])
                    continue;
                visited[i]=true;
                al.add(nums[i]);
                helper(nums,visited,ll,al,c+1);
                visited[i]=false;
                al.remove(al.size()-1);
            }
        }
    }
}
