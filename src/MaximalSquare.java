public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int[][] arr=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    arr[i][j]=1;
                }
                else{
                    arr[i][j]=0;
                }
            }
        }
        int n=arr.length;
        int m=arr[0].length;
        int[][] dp=new int[n][m];
        int sum=0;
        for(int i=0;i<n;i++){
            dp[i][0]=arr[i][0];

        }
        for(int j=0;j<m;j++){
            dp[0][j]=arr[0][j];

        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(arr[i][j]==0) dp[i][j]=0;
                else{
                    dp[i][j]=1+Math.min(Math.min(dp[i][j-1],dp[i-1][j-1]),dp[i-1][j]);
                }

            }
        }
        int area=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                area=Math.max(dp[i][j]*dp[i][j],area);
            }
        }
        return area;
    }
}
