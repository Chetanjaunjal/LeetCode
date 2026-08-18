class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int start = 1;
        int end = 1000000;
        int ans = end;
        while(start <= end){
            int mid = (start + end)/2;
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += (nums[i] + mid - 1)/mid;
            }
            if(sum <= threshold){
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}