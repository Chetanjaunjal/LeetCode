class Solution {
    public int maxProduct(int[] nums) {
       int n = nums.length;
       int i = Integer.MIN_VALUE;
       int j = Integer.MIN_VALUE;
       for(int num : nums){
        if(num > i){
             j = i;
             i = num;
        } else if(num > j){
            j = num;
        }
       }
       return (i - 1)*(j - 1);
    }
}