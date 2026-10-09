class Solution {
    public int maxScore(int[] arr, int k) {
        int n = arr.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += arr[i];
        }

        if (k == n) {
            return total;
        }

        int windowSize = n - k;
        int windowSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSum += arr[i];
        }

        int minSum = windowSum;

        for (int i = windowSize; i < n; i++) {
            windowSum = windowSum - arr[i - windowSize] + arr[i];

            if (windowSum < minSum) {
                minSum = windowSum;
            }
        }

        return total - minSum;
    }
}