class Solution {
    public int countPaths(int[][] grid) {
        return dfs(grid, 0, 0);
    }

    public int dfs(int[][] grid, int r, int c) {

        if(grid.length < 1) {
            return 0;
        }
        int ROWS = grid.length, COLS = grid[0].length;
        if(Math.min(r, c) < 0 || r >= ROWS || c >= COLS || grid[r][c] == 1) {
            return 0;
        }
        if(r == ROWS-1 && c == COLS-1) {
            return 1;
        }
        int count =0;

        grid[r][c] = 1;
        count = count + this.dfs(grid, r+1, c);
        count = count + this.dfs(grid, r-1, c);
        count = count + this.dfs(grid, r, c+1);
        count = count + this.dfs(grid, r, c-1);
        grid[r][c] = 0;
        return count;
    }
}

