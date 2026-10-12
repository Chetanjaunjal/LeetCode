
import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = fruits.length;
        int r = 0;
        int l = 0;
        int maxlen = 0;
        int k = 2;
        while (r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            if (map.size() > k) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            if (map.size() <= k) {
                int len = r - l + 1;
                maxlen = Math.max(maxlen, len);
            }
            r++;
        }
        return maxlen;
    }
}
