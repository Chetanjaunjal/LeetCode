class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -10000000000L;
        long high = 10000000000L;
        while (low < high) {
            long mid = low + (high - low) / 2;
            long count = countProducts(nums1, nums2, mid);
            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public long countProducts(int[] nums1, int[] nums2, long x) {
        long count = 0;
        for (int a : nums1) {
            if (a > 0) {
                int low = 0;
                int high = nums2.length;
                while (low < high) {
                    int mid = (low + high) / 2;
                    if ((long) a * nums2[mid] <= x) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
           count += low;
            }
            else if (a < 0) {
                int low = 0;
                int high = nums2.length;
                while (low < high) {
                    int mid = (low + high) / 2;
                    if ((long) a * nums2[mid] <= x) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
                count += nums2.length - low;
            }
            else {
                if (x >= 0) {
                    count += nums2.length;
                }
            }
        }
        return count;
    }
}