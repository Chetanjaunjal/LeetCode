class Solution {
    private int countAtMost(int[] nums, int limit) {
        if (limit < 0) {
            return 0;
        }
        int left = 0;
        int currentSum = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            currentSum += (nums[right]%2);
            while (currentSum > limit) {
                currentSum -= (nums[left]%2);
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
     public int numberOfSubarrays(int[] nums, int k) {
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }
}