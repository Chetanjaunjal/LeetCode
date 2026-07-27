class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] mergeArray = new int[n+m];
        int i = 0, j = 0, k = 0;
        while(i < n && j < m){
            if (nums1[i] <= nums2[j]){
                mergeArray[k++] = nums1[i++];
            } else {
                mergeArray[k++] = nums2[j++];
            }
        }
             while (i < n) {
            mergeArray[k++] = nums1[i++];
        }
        while (j < m) {
            mergeArray[k++] = nums2[j++];
        }
        int z = mergeArray.length;
        float median = 0;
        //int idx1 = z/2;
        int idx2 = (z/2)-1;
            if(z%2 == 0){
                median = (mergeArray[z/2] + mergeArray[idx2])/2.0f;
            } else {
                median = mergeArray[z/2];
            }
            return median;
    }
}