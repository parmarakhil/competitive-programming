public class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0, j = 0; j < board[0].length; j++){
            if(board[i][j] == 'O'){
                dfs(board, i, j);
            }
        }
        for(int i = 0, j = n - 1; i < m; i++){
            if(board[i][j] == 'O'){
                dfs(board, i, j);
            }
        }
        for(int i = m - 1, j = n - 1; j >= 0; j--){
            if(board[i][j] == 'O'){
                dfs(board, i, j);
            }
        }
        for(int i = m - 1, j = 0; i >= 0; i--){
            if(board[i][j] == 'O'){
                dfs(board, i, j);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(board[i][j] == '1'){
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }

        }
    }
    int [][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // tldr
    private void dfs(char [][] board, int i, int j){

        board[i][j] = '1';

        for(int [] dir : dirs){
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni >= 0 && ni < board.length && nj >= 0 && nj < board[i].length && board[ni][nj] == 'O'){
                dfs(board, ni, nj);
            }
        }
    }
}
