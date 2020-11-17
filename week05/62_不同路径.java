/*
思路：首先把第一行和第一列的值赋为1
		然后从第二行第二列开始操作
		每个点的值为   它上方的值  和   它左边的值相加的和


*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i = 0; i<m; i++)
            dp[i][0] = 1;
        for(int i = 0; i<n; i++)
            dp[0][i] = 1;

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
  
    }
}