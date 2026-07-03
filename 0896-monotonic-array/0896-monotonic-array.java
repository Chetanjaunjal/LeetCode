class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                break;
            }
            if (i == n - 2) {
                return true;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                return false;
            }
        }

        return true;
    }
}