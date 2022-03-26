public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int[][] lengths = new int[matrix.length][matrix[0].length];//measure the length of every row at every index
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j - 1 >= 0 && matrix[i][j] != '0')
                    lengths[i][j] = lengths[i][j - 1] + (int) matrix[i][j] - 48;
                else
                    lengths[i][j] = (int) matrix[i][j] - 48;
            }
        }

        for (int c = 0; c < lengths[0].length; c++) {//Inspect every column neighbor to determine if it is bigger or equal to the current column value.
            for (int r = 0; r < lengths.length; r++) {
                int currentMax = lengths[r][c];
                if (currentMax == 0)//If the value is 0 skip
                    continue;
                int current = lengths[r][c];
                int currentRow = r - 1;
                while (currentRow >= 0) {//looking up the column
                    if (lengths[currentRow][c] >= current)
                        currentMax += current;//If it is bigger or equal to, add the current column value to the total
                    else
                        break;
                    currentRow -= 1;
                }
                currentRow = r + 1;
                while (currentRow < lengths.length) {//looking down the column
                    if (lengths[currentRow][c] >= current)
                        currentMax += current;//If it is bigger or equal to, add the current column value to the total
                    else
                        break;
                    currentRow += 1;
                }
                if (currentMax > maxArea)//Find the max value
                    maxArea = currentMax;
            }
        }
        return maxArea;
    }
}
