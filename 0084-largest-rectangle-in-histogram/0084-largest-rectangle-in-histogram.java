class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int current = (i == n) ? 0 : heights[i];

            while (!st.isEmpty() && heights[st.peek()] >= current) {
                int height = heights[st.pop()];

                int width;
                if (st.isEmpty()) {
                    width = i;
                } else {
                    width = i - st.peek() - 1;
                }

                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }

            if (i < n) {
                st.push(i);
            }
        }

        return maxArea;
    }
}