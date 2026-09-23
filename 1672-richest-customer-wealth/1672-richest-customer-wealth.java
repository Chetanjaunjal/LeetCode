class Solution {
    public int maximumWealth(int[][] accounts) {
        int n = accounts.length , m = accounts[0].length;
        int maxwealth = -1;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = 0; j < m; j++){ 
                sum += accounts[i][j];
            }
            if(sum > maxwealth){
                maxwealth = sum;
            }
        }
        return maxwealth;
    }
}