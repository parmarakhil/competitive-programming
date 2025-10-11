import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        System.out.println(courseSchedule1(new int[][]{{1,0},{2,1},{3,2}}, 4));
    }
    public static boolean courseSchedule(int[][] tasks, int numberOfTasks) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<4; i++) {
            adj.add(new ArrayList<>());
        }
        int m = tasks.length;
        for (int i=0; i<m; i++) {
            adj.get(tasks[i][0]).add(tasks[i][1]);
        }

        int indegree[] = new int[numberOfTasks];
        for (int i=0; i<numberOfTasks; i++) {
            for (int it:adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<numberOfTasks; i++) {
            if(indegree[i]==0) {
                queue.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while(!queue.isEmpty()) {
            int node = queue.peek();
            queue.remove();
            topo.add(node);

            for (int it:adj.get(node)) {
                indegree[it]--;
                if (indegree[it]==0) queue.add(it);
            }
        }

        if(topo.size() ==numberOfTasks) return true;
        return false;
    }

    public static List<Integer> courseSchedule1(int[][] tasks, int numberOfTasks) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<4; i++) {
            adj.add(new ArrayList<>());
        }
        int m = tasks.length;
        for (int i=0; i<m; i++) {
            adj.get(tasks[i][1]).add(tasks[i][0]);
        }

        int indegree[] = new int[numberOfTasks];
        for (int i=0; i<numberOfTasks; i++) {
            for (int it:adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<numberOfTasks; i++) {
            if(indegree[i]==0) {
                queue.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while(!queue.isEmpty()) {
            int node = queue.peek();
            queue.remove();
            topo.add(node);

            for (int it:adj.get(node)) {
                indegree[it]--;
                if (indegree[it]==0) queue.add(it);
            }
        }

        if(topo.size() ==numberOfTasks) return topo;
        return new ArrayList<>();
    }
}
