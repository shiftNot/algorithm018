/*
哔哩哔哩视频讲解：
https://www.bilibili.com/video/BV1wV411S7SY?from=search&seid=8418894508800694895
小姐姐视频讲解哦！


思路：
1.点击的如果是炸弹，把'M'改为'X',返回原数组即可
2.如果点击的是别的地方，进行dfs
3.dfs的过程呢就是：
*/

class Solution {
   // int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
   // int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};
   //这是官方给出的偏移坐标

    int[] dx = {0,0,-1,-1,-1,1,1,1};
    int[] dy = {-1,1,0,1,-1,0,1,-1};

    public char[][] updateBoard(char[][] board, int[] click) {
        
        int n = board.length;
        int m = board[0].length;

        int x = click[0];
        int y = click[1];
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
        }
        else{
            dfs(board,x,y);
        }

        return board;
    }

    public void dfs(char[][] b,int x,int y){
        int count = 0;
        int n = b.length;
        int m = b[0].length;
        for(int i=0;i<8;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];        
            if(nx>=0 && nx<n && ny>=0 && ny<m && b[nx][ny]=='M'){
                count++;
                b[x][y] = (char)('0'+count);
            }
        }
        if(count==0){
            b[x][y] = 'B';
            for(int i=0;i<8;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];    
/*          //起点,如果这里这样写的话，会导致栈溢出。
               if(nx>=0 && nx<n && ny>=0 && ny<m){ 
                dfs(b,nx,ny);
                 }
            //终点
*/
             if(nx>=0 && nx<n && ny>=0 && ny<m && b[nx][ny]=='E'){
                dfs(b,nx,ny);
            }

            }
        }
    }
}