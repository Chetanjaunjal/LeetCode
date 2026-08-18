class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > n) {
            return -1;
        }
        int start = 1;
        int end = 1000000000;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int cnt = 0;
            int bouquet = 0;
            for (int i = 0; i < n; i++) {
                if (bloomDay[i] <= mid) {
                    cnt++;
                } else {
                    bouquet += cnt / k;
                    cnt = 0;
                }
            }
            bouquet += cnt / k;
            if (bouquet >= m) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}