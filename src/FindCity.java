import java.util.Arrays;

/**
 * find the city with the smallest number of neighbours at a threshold distance
 * */
public class FindCity {

    public int findTheCity(int n, int[][] edges, int distanceThreshold){
        int dp[][] = new int[n][n];
        for(int i=0; i<n;i++){
            Arrays.fill(dp[i],100001);
            dp[i][i]=0;
        }

        for(int[] e:edges){
            dp[e[0]][e[1]] = e[2];
            dp[e[1]][e[0]] = e[2];
        }

        for(int k=0; k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0; j<n;j++){
                    dp[i][j]=Math.min(dp[i][j], dp[i][k]+dp[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int ans =-1;
        for(int i=0; i<n;i++){
            int count =0;
            for(int j=0; j<n;j++){
                if(i!=j && dp[i][j]<= distanceThreshold){
                    count++;
                }
            }
            if(count<=min){
                min = count;
                ans=i;
            }
        }
        return ans;
    }
}
