class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            boolean stuck = false; 
            int col = i;
            for (int j = 0; j < m; j++) {
                if (grid[j][col] == 1) {
                    if (col == n - 1 || grid[j][col + 1] == -1) {
                        stuck = true;
                        break;
                    }
                    col++;
                } else {
                    if (col == 0 || grid[j][col - 1] == 1) {
                        stuck = true;
                        break;
                    }
                    col--;
                }
            }
            if (stuck) {
                ans[i] = -1;
            } else {
                ans[i] = col;
            }
        }
        return ans;
    }
}