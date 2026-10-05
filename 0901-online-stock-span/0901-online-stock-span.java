class StockSpanner {

    Stack<Integer> prices = new Stack<>();
    Stack<Integer> spans = new Stack<>();

    public StockSpanner() {
        
    }

    public int next(int price) {
        int span = 1;

        while (!prices.empty() && prices.peek() <= price) {
            prices.pop();
            span += spans.pop();
        }

        prices.push(price);
        spans.push(span);

        return span;
    }
}

// class Solution {
//     public int[] calculateSpan(int[] prices) {
//         int n = prices.length;
//         int[] spans = new int[n];
//         Stack<Integer> stack = new Stack<>();
//         for (int i = 0; i < n; i++) {
//             while (!stack.empty() && prices[stack.peek()] <= prices[i]) {
//                 stack.pop();
//             }

//             if (stack.empty()) {
//                 spans[i] = i + 1;
//             } else {
//                 spans[i] = i - stack.peek();
//             }

//             stack.push(i);
//         }

//         return spans;
//     }
// }
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */