/*
哔哩哔哩上讲解链接：https://www.bilibili.com/video/BV1ra411c7nJ?from=search&seid=8418894508800694895

这里有个要注意的点就是，在声明row和col两个变量时，要设置成全局的，因为在dfs方法中会用到。


*/

class Solution {

    int row,col;
    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;

        int res = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid,int i,int j ){
        if(i<0 || j<0 || i >= row || j >= col || grid[i][j]=='0') return;

        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}