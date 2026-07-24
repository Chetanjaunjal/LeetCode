class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
    
        int n = nums.length;
        int[] ext = new int[n];
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j =0; j<n; j++){
                if(nums[i] > nums[j]){
                    count++;
                }
            }
            ext[i] = count;
        }   
        return ext;
    }
}