// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int n = nums.length;
//         int start = 0;
//         int end = n - 1;
//         int lb = n;
//         int hb = n;
//             while(start<=end){
//                 int mid = start + (end - start)/2;
//                 if(nums[mid] >= target){
//                     lb = mid;
//                 }else if(nums[mid]<target){
//                     start = mid + 1;
//                 } else {
//                     end = mid -1;
//                 }
//             }

//                  while(start<=end){
//                 int mid2 = start + (end - start)/2;
//                 if(nums[mid2] > target){
//                     hb = mid2;
//                 }else if(nums[mid2]<target){
//                     start = mid2 + 1;
//                 } else {
//                     end = mid2 -1;
//                 }
//     }
//     if(lb == n || nums[lb] != target) return new int[]{-1,-1};

//    return new int[]{lb, hb - 1};
// }
// }


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int start = 0;
        int end = n - 1;
        int lb = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= target) {
                lb = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (lb == n || nums[lb] != target) {
            return new int[]{-1, -1};
        }

        start = 0;
        end = n - 1;
        int hb = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > target) {
                hb = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return new int[]{lb, hb - 1};
    }
}