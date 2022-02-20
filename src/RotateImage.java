public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        for(int i = 0; i < n/2; i++){
            for(int j = i; j < (n-i-1); j++){
                int k = i, l = j;
                int temp1, temp2 = matrix[i][j];
                do{
                    temp1 = temp2;
                    int t = n-1-i;
                    i = j;
                    j = t;
                    temp2 = matrix[i][j];
                    matrix[i][j] = temp1;
                    if(i == k && j == l)  break;
                }while(true);
            }
        }
    }
}
