class Solution {
    int directions[][] = new int[][]{{1, 0}, {-1,0}, {0, 1}, {0,-1}};
    public int numIslands(char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        /**
        Perform BFS
        **/
        int islands = 0; 
        for(int r=0; r< ROWS; r++) {
            for(int c=0; c< COLS; c++) {
                if(grid[r][c] == '1') {
                    bfs(grid, r, c, ROWS, COLS);
                    islands = islands+1;
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, int row, int col, int ROWS, int COLS) {
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{row, col});
        while(!q.isEmpty()) {
            int element[] = q.poll();
            grid[element[0]][element[1]] = '0';
            for(int k=0; k < directions.length; k++) {
                int nr = element[0] + directions[k][0];
                int nc = element[1] + directions[k][1];
                if(Math.min(nr, nc) < 0 || nr >=ROWS || nc >= COLS || grid[nr][nc] == '0') {
                    continue;
                }
                q.offer(new int[]{nr, nc});
            }
        }
    }
}
