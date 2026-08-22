class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        for(int x = n; x > 0; x/=10){
            int r = x % 10;
            sum += r;
            product *= r;
        }
        return n%(sum+product) == 0;
    }
}