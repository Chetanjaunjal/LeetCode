class Solution {
    public boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;
        boolean deleted = false;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } 
            else {
                int l = left + 1;
                int r = right;
                boolean skipLeft = true;
                while (l < r) {
                    if (s.charAt(l) != s.charAt(r)) {
                        skipLeft = false;
                        break;
                    }
                    l++;
                    r--;
                }
                l = left;
                r = right - 1;
                boolean skipRight = true;
                while (l < r) {
                    if (s.charAt(l) != s.charAt(r)) {
                        skipRight = false;
                        break;
                    }
                    l++;
                    r--;
                }
                return skipLeft || skipRight;
            }
        }
        return true;
    }
}