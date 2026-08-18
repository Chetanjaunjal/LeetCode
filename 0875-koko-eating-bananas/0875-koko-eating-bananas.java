class Solution {
       public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 1000000000;
        while ( start < end) {
            int mid = (start + end) / 2;
            long total = 0;
            for (int p = 0; p < piles.length; p++)
                total += (piles[p] + mid - 1) / mid;
            if (total > h){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}