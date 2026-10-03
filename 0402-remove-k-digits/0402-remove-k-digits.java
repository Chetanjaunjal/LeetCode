import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (k > 0 && !st.isEmpty() && st.peek() > digit) {
                st.pop();
                k--;
            }
            st.push(digit);
        }

        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();

        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        result.reverse();

        int i = 0;
        while (i < result.length() && result.charAt(i) == '0') {
            i++;
        }

        if (i == result.length()) {
            return "0";
        }

        return result.substring(i);
    }
}