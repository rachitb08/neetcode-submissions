class Solution {
    /**
    1. Find an unvisited valid cell
    2. Do something
    3. Mark it visited
    4. Explore 4 directions
    
    Find '1'
    ↓
    count++
    ↓
    DFS
    ↓
    convert connected '1's → '0'
    ↓
    continue scanning
     */

    public int numIslands(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        if (grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
    }
}