class Solution {
    public int[] sortedSquares(int[] nums) {    
        int i = 0;
        int j = nums.length - 1;
        int k = j;

        int[] arr = new int[nums.length];

        while (i < j) {
            int iSquare = nums[i] * nums[i];
            int jSquare = nums[j] * nums[j];

            if (iSquare > jSquare) {
                arr[k--] = iSquare;
                i++;
            } else {
                arr[k--] = jSquare;
                j--;
            }
        }

        arr[0] = nums[i] * nums[i];
        return arr;
    }
}