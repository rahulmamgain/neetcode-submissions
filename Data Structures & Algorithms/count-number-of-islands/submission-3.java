class Solution {
    public int numIslands(char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length, res = 0;
        for(int r=0; r<ROWS; r++) {
            for(int c=0; c<COLS; c++) {
                if(grid[r][c] == '1') {
                    bfs(grid, r, c, ROWS, COLS);
                    res = res+1;
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int row, int col, int ROWS, int COLS) {
        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0,1}};
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{row, col});
        while(!q.isEmpty()) {
            int[] el = q.poll();
            grid[el[0]][el[1]] = '0';
            for(int[] direction: directions) {
                int nr = el[0] + direction[0];
                int nc = el[1] + direction[1];
                if(Math.min(nr, nc) < 0 || nr >= ROWS || nc >= COLS || grid[nr][nc] == '0') continue;
                q.offer(new int[]{nr, nc});
            }
        }
    }
}
