import java.util.ArrayList;
import java.util.List;

public class Combine {

    public static List<List<Integer>> result;

    public static void getComb(int left, int n, int start, List<Integer> cur) {
        if (left == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < n; i++) {
            cur.add(i + 1);
            getComb(left - 1, n, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        getComb(k, n, 0, cur);
        return result;
    }
}
