class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int size = 0;
        if(grid.length < 1) {
            return size;
        }
        int ROWS = grid.length, COLS = grid[0].length;
        for(int r=0; r < ROWS; r++) {
            for(int c=0; c < COLS; c++) {
                if(grid[r][c] == 1) {
                    int currentSize = dfs(grid, r, c, ROWS, COLS);
                    size = Math.max(size, currentSize);
                }
            }
        }
        return size;
    }

    private int dfs(int[][] grid, int r, int c, int ROWS, int COLS) {
        if(Math.min(r, c) < 0 || r >= ROWS || c >= COLS || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        int maxSize = 1;
        maxSize += dfs(grid, r+1, c, ROWS, COLS);
        maxSize += dfs(grid, r-1, c, ROWS, COLS);
        maxSize += dfs(grid, r, c+1, ROWS, COLS);
        maxSize += dfs(grid, r, c-1, ROWS, COLS);
        return maxSize;
    }
}
