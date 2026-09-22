// class Solution {
//     public int lowerBound(int[] arr, int n, int x){
//         int low = 0, high = n - 1;
//         int ans = n;
//         while(low <= high){
//             int mid = (low + high) / 2;
//             if(arr[mid] >= x){
//                 ans = mid;
//                 high = mid - 1;
//             }else{
//                 low = mid + 1;
//             }
//         } 
//         return ans;
//     }
//     public int[] rowAndMaximumOnes(int[][] mat) {
//         int n = mat.length, m = mat[0].length;
//         int cnt_max = 0;
//         int index = -1;
//         for(int i = 0; i < n; i++){
//             int cnt_ones = m - lowerBound(mat[i], m ,1);
//             if(cnt_ones > cnt_max){
//                 cnt_max = cnt_ones;
//                 index = i;
//             }
//         }
//         int[] ans = new int[]{index, cnt_max};
//        return ans;
//     }
// }

class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int maxOnes = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            if (count > maxOnes) {
                maxOnes = count;
                index = i;
            }
        }
        return new int[]{index, maxOnes};
    }
}