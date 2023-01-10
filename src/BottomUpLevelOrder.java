import java.util.*;

public class BottomUpLevelOrder {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        traverseBST(root, map, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (int key : map.keySet()) result.add(map.get(key));
        return result;
    }

    private void traverseBST(TreeNode node, Map<Integer, List<Integer>> map, int lvl) {
        if (node == null) return;

        lvl++;

        traverseBST(node.left, map, lvl);

        if (map.containsKey(lvl)) {
            map.get(lvl).add(node.val);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            map.put(lvl, list);
        }

        traverseBST(node.right, map, lvl);
    }
}
