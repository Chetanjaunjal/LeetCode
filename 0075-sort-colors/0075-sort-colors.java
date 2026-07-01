class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zero = 0;
        int one = 0;
        int two = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0) zero++;
            else if(nums[i] == 1)one++;
            else two++;
        }
        for(int i =0; i<=n-1; i++){
            if(i<zero) nums[i] = 0;
            else if(i<zero + one) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}