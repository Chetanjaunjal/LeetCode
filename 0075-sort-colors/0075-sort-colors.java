class Solution {
    public void sortColors(int[] nums) {

        int n = nums.length;

        int[] zero = new int[n];
        int[] one = new int[n];
        int[] two = new int[n];
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero[a++] = 0;
            } else if (nums[i] == 1) {
                one[b++] = 1;
            } else {
                two[c++] = 2;
            }
        }
        int index = 0;
        for (int i = 0; i < a; i++) {
            nums[index++] = zero[i];
        }
        for (int i = 0; i < b; i++) {
            nums[index++] = one[i];
        }
        for (int i = 0; i < c; i++) {
            nums[index++] = two[i];
        }
    }
}