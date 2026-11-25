class Solution {
    char[][] board;
    int m,n;
    int i,j;
    int[][] dirc={{0,1},{1,0},{0,-1},{-1,0}};
    public void solve(char[][] board) {
        this.board=board;
        m=board.length;
        n=board[0].length;
        //first row
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                dfs(0,j);
            }
        }
        //last row
        for(j=0;j<n;j++){
            if(board[m-1][j]=='O'){
                dfs(m-1,j);
            }
        }

        //first column
        for(i=0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(i,0);
            }
        }
        //last column
        for(i=0;i<m;i++){
            if(board[i][n-1]=='O'){
                dfs(i,n-1);
            }
        }

        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }

    public void dfs(int i,int j){
        if(i<0 || j<0 || i>=m || j>=n){
            return;
        }
        if(board[i][j]!='O'){
            return;
        }
        board[i][j]='#';


        for(int[] dir:dirc){
            int nr=i+dir[0];
            int nc=j+dir[1];

            dfs(nr,nc);
        }

    }
}