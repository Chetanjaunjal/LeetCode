import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int max = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            max = Math.max(max, largestRectangle(heights));
        }

        return max;
    }

    public int largestRectangle(int[] heights) {
        Stack<Integer> st = new Stack<>();

        int max = 0;

        for (int i = 0; i <= heights.length; i++) {

            int current;

            if (i == heights.length) {
                current = 0;
            } else {
                current = heights[i];
            }

            while (!st.isEmpty() && heights[st.peek()] > current) {
                int height = heights[st.pop()];

                int width;

                if (st.isEmpty()) {
                    width = i;
                } else {
                    width = i - st.peek() - 1;
                }

                max = Math.max(max, height * width);
            }

            st.push(i);
        }

        return max;
    }
}