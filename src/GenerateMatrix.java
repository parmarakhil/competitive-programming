public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int mat[][] = new int[n][n];
        int row_start = 0, col_start = 0, row_end = n-1, col_end = n-1, k = 1;
        while (row_start <= row_end && col_start <= col_end) {
            for (int col = col_start; col <= col_end; col++) mat[row_start][col] = k++;
            row_start++;
            for (int row = row_start; row <= row_end; row++) mat[row][col_end] = k++;
            col_end--;
            for (int col = col_end; col >= col_start; col--) mat[row_end][col] = k++;
            row_end--;
            for (int row = row_end; row >= row_start; row--) mat[row][col_start] = k++;
            col_start++;
        }
        return mat;
    }
}
