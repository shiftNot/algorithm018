class Solution {
    int res = 0;
    int cnt = 1,sx,sy,ex,ey;//这里一定要用cnt为1来初始化，因为走到2还需要一步路
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    cnt++;
                }
                else if(grid[i][j] == 1){
                    sx = i;
                    sy = j; 
                }
                else if(grid[i][j] == 2){
                    ex = i;
                    ey = j;
                }
            }
        }

        dfs(grid,sx,sy);
        return res;
    }

    public void dfs(int[][] grid, int x , int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0)return;
        if(x == ex && y == ey){
            if(cnt == 0)res++;
            return;
        }
        cnt--;
        grid[x][y] = -1;
        
        dfs(grid,x-1,y);
        dfs(grid,x+1,y);
        dfs(grid,x,y-1);
        dfs(grid,x,y+1);
        grid[x][y] = 0;
        cnt++;

    }
}