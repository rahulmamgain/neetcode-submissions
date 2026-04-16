class Solution {
    public int numIslands(char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        if(grid.length < 1) {
            return 0;
        }
        int count=0;
        for(int r=0; r<ROWS; r++ ) {
            for(int c=0; c<COLS; c++) {
                if(grid[r][c] == '1') {
                    dfs(grid, r, c, ROWS, COLS);
                    count = count + 1;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c, int ROWS, int COLS) {
        if(Math.min(r, c) < 0 || r >= ROWS || c>= COLS || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        this.dfs(grid, r+1, c, ROWS, COLS);
        this.dfs(grid, r-1, c, ROWS, COLS);
        this.dfs(grid, r, c+1, ROWS, COLS);
        this.dfs(grid, r, c-1, ROWS, COLS);
    }
}
