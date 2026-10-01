import java.util.*;

class Solution {
    // Return the sum of every subarray range.
    public long subArrayRanges(int[] nums) {
        // Store the accumulated range sum.
        long answer = 0;

        // Choose every possible starting index.
        for (int start = 0; start < nums.length; start++) {
            // Track extrema for the growing subarray.
            int minimum = nums[start];
            int maximum = nums[start];

            // Extend the current subarray to the right.
            for (int end = start; end < nums.length; end++) {
                // Include the new value in both extrema.
                minimum = Math.min(minimum, nums[end]);
                maximum = Math.max(maximum, nums[end]);

                // Add the range of the current subarray.
                answer += (long) maximum - minimum;
            }
        }

        // Return the sum after every pair is visited.
        return answer;
    }
}