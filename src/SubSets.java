import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();

        dfs(nums, 0, out, result);

        return result;
    }

    public void dfs(int[] nums, int idx, List<Integer> out, List<List<Integer>> result) {
        if (idx == nums.length) {
            List<Integer> temp = new ArrayList<>(out);
            result.add(temp);
            return;
        }

        //two choices
        //1. select the current num
        out.add(nums[idx]);
        dfs(nums, idx + 1, out, result);

        //2. not select the current num
        out.remove(out.size() - 1);
        dfs(nums, idx + 1, out, result);
    }
}
