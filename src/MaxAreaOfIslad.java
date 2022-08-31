public class MaxAreaOfIslad {

    public int maxAreaOfIsland(int[][] grid) {

        int R = grid.length;
        int C = grid[0].length;

        int maxCount = 0;
        for (int i=0; i < R; i++){
            for(int j=0; j < C; j++){
                int count = dfs(i, j, grid, R, C);
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }

    public int dfs(int i, int j, int[][] grid, int R, int C){
        //boundry condition
        if(i < 0 || i >= R || j < 0 || j >= C || grid[i][j] != 'T' ){
            return 0;
        }

        int area = 0;
        //Mark Visited
        grid[i][j] = 0;

        //UP
        area += dfs(i+1, j, grid, R, C);
        //Down
        area += dfs(i-1, j, grid, R, C);
        //Right
        area += dfs(i, j+1, grid, R, C);
        //Left
        area += dfs(i, j-1, grid, R, C);

        // Increase counter and return
        return area + 1;
    }
}
