class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //获取路径数组的长宽  
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        //判断路径数组的第一个格子，给dp首元素赋值
        if(obstacleGrid[0][0]==1)
            return 0;
        else{
            dp[0][0] = 1;
        }

        //把dp的第一行和第一列赋值，条件是：若该处没有石头且它前面的那个格子可以到达，则此处可以到达，dp赋值为1
        for(int i =1;i<m;i++){    
            if(obstacleGrid[i][0]==0 &&  dp[i-1][0]==1 )
                dp[i][0] = 1;
            else{
                dp[i][0] = 0;   
            }
        }

        for(int i =1;i<n;i++){    
            if(obstacleGrid[0][i]==0 &&  dp[0][i-1]==1)
                dp[0][i] = 1;
            else{
                dp[0][i] = 0;   
            }
        }

        //循环过程中，碰到石头就赋值为0，其他的情况都是由 （左边值+上边值）
        for(int i = 1;i<m;i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
                
            }
        }
        return dp[m-1][n-1];
    }
}