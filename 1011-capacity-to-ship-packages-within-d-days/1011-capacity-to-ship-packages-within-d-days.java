class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int start = 0;
        int end = 0;
        for (int weight : weights) {
            start = Math.max(start, weight);
            end += weight;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int noDays = 1;
            int load = 0;
            for (int i = 0; i < n; i++) {
                if (load + weights[i] > mid) {
                    noDays++;
                    load = weights[i];
                } else {
                    load += weights[i];
                }
            }
            if (noDays <= days) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}