import java.util.*;

class Solution {

    private int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            int currEle = arr[i];

            while(!st.isEmpty() && arr[st.peek()] >= currEle) {
                st.pop();
            }

            ans[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }

        return ans;
    }

    private int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            int currEle = arr[i];

            while(!st.isEmpty() && arr[st.peek()] <= currEle) {
                st.pop();
            }

            ans[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }

        return ans;
    }

    private int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            int currEle = arr[i];

            while(!st.isEmpty() && arr[st.peek()] > currEle) {
                st.pop();
            }

            ans[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }

        return ans;
    }

    private int[] findPGEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            int currEle = arr[i];

            while(!st.isEmpty() && arr[st.peek()] < currEle) {
                st.pop();
            }

            ans[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }

        return ans;
    }

    private long sumSubarrayMins(int[] arr) {
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);

        int n = arr.length;
        long sum = 0;

        for(int i = 0; i < n; i++) {
            long left = i - psee[i];
            long right = nse[i] - i;
            long freq = left * right;
            long val = freq * arr[i];

            sum += val;
        }

        return sum;
    }

    private long sumSubarrayMaxs(int[] arr) {
        int[] nge = findNGE(arr);
        int[] pgee = findPGEE(arr);

        int n = arr.length;
        long sum = 0;

        for(int i = 0; i < n; i++) {
            long left = i - pgee[i];
            long right = nge[i] - i;
            long freq = left * right;
            long val = freq * arr[i];

            sum += val;
        }

        return sum;
    }

    public long subArrayRanges(int[] arr) {
        return sumSubarrayMaxs(arr) - sumSubarrayMins(arr);
    }
}

public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        Solution sol = new Solution();

        long ans = sol.subArrayRanges(arr);

        System.out.println("The sum of subarray ranges is: " + ans);
    }
}