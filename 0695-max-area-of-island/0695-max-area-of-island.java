class Solution {
    private int m;
    private int n;
    int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid=grid;
        m=grid.length;
        n=grid[0].length;
        int max=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    max=Math.max(max,dfs(i,j));        
                }
            }
        }
        return max;
        
    }
    private int dfs(int i, int j) {

        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0)
            return 0;

        grid[i][j] = 0;

        return 1
                + dfs(i + 1, j)
                + dfs(i - 1, j)
                + dfs(i, j + 1)
                + dfs(i, j - 1);
    }
}