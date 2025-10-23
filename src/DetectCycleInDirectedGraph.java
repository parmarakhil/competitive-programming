import java.util.List;

public class DetectCycleInDirectedGraph {

    public static boolean detectCycleInDirectedGraph(int n, List<List<Integer>> adj) {
        int[] visited = new int[n];
        int[] pathVisited = new int[n];

        for (int i=0; i<n; i++) {
            if (visited[i] ==0) {
                if (dfsCheck(i, adj, visited, pathVisited) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsCheck(int node, List<List<Integer>> adj, int[] visited, int[] pathVisited) {
        visited[node] =1;
        pathVisited[node] =1;

        // traverse for adjacent node
        for (int i: adj.get(node)) {
            if (visited[i] == 0) {
                if (dfsCheck(i, adj, visited, pathVisited) == true) {
                    return true;
                }
                // if the node has been previsously visited but it has to be visited on same path
                else if (pathVisited[i] ==1) {
                    return true;
                }
            }
        }
        pathVisited[node] =0;
        return false;
    }
}
