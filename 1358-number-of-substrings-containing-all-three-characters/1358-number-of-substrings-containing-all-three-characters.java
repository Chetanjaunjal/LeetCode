class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        if (n < 3) {
            return 0;
        }
        int[] frequency = new int[3];
        int left = 0;
        int count = 0;
        for (int right = 0; right < n; right++) {
            frequency[s.charAt(right) - 'a']++;
            while (
                frequency[0] > 0 &&
                frequency[1] > 0 &&
                frequency[2] > 0
            ) {
                count += n - right;
                frequency[s.charAt(left) - 'a']--;
                left++;
            }
        }
 
        return count;
    }
}