class Solution {

    int m, n;
    int[][] heights;
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific DFS (top row)
        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific);
        }

        // Pacific DFS (left column)
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
        }

        // Atlantic DFS (bottom row)
        for (int j = 0; j < n; j++) {
            dfs(m - 1, j, atlantic);
        }

        // Atlantic DFS (right column)
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    private void dfs(int r, int c, boolean[][] visited) {

        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        for (int[] dir : directions) {

            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                continue;
            }

            // Move only to equal or higher cells
            if (heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, visited);
            }
        }
    }
}