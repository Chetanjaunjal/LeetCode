class Solution {
    private int[] findPreviousLess(int[] arr) {
        int n = arr.length;
        int[] previousLess = new int[n];
        Arrays.fill(previousLess, -1);
        Stack<Integer> indices = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!indices.isEmpty()
                    && arr[indices.peek()] >= arr[i]) {
                indices.pop();
            }
            if (!indices.isEmpty()) {
                previousLess[i] = indices.peek();
            }
            indices.push(i);
        }

        return previousLess;
    }


    private int[] findNextLessOrEqual(int[] arr) {
        int n = arr.length;
        int[] nextLessOrEqual = new int[n];
        Arrays.fill(nextLessOrEqual, n);

        Stack<Integer> indices = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!indices.isEmpty()
                    && arr[indices.peek()] > arr[i]) {
                indices.pop();
            }
            if (!indices.isEmpty()) {
                nextLessOrEqual[i] = indices.peek();
            }
            indices.push(i);
        }

        return nextLessOrEqual;
    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long mod = 1000000007L;

        int[] previousLess = findPreviousLess(arr);
        int[] nextLessOrEqual = findNextLessOrEqual(arr);

        long answer = 0;

        for (int i = 0; i < n; i++) {
            long leftChoices = i - previousLess[i];
            long rightChoices = nextLessOrEqual[i] - i;
            long contribution =
                (arr[i] * leftChoices) % mod;
            contribution =
                (contribution * rightChoices) % mod;
            answer = (answer + contribution) % mod;
        }

        return (int) answer;
    }
}