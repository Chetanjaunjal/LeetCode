public class Solution {
    public int[] findDiagonalOrder(int[][] arr) {

        int m = arr.length, n = arr[0].length;
        int[] ans = new int[m * n];
        int row = 0, col = 0;

        for (int i = 0; i < m * n; i++) {
            ans[i] = arr[row][col];

            if ((row + col) % 2 == 0) {
                if (col == n - 1) row++;
                else if (row == 0) col++;
                else { row--; col++; }
            } else {
                if (row == m - 1) col++;
                else if (col == 0) row++;
                else { row++; col--; }
            }
        }

        return ans;
    }
}