public class CoinChange {
    public int coinChange(int coins[],int amt){
        int n=coins.length; // Number of different coins
        int[][] dp = new int[n + 1][amt + 1]; // DP array for tabulation
        for(int i=0;i<=n;i++){
            for(int j=0;j<=amt;j++){
                if(i==0) {
                    dp[i][j] = 0; // Base case: no coins means no ways to make change
                } else if(j==0) {
                    dp[i][j] = 1; // Base case: one way to make change for amount 0 (use no coins)
                } else if(coins[i-1] <= j) {
                    // Include the coin and check the remaining amount
                    dp[i][j] = dp[i][j - coins[i-1]] + dp[i-1][j];
                } else {
                    // Exclude the coin and carry forward the previous result
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
       return dp[n][amt]; // Return the number of ways to make change for the given amount
    } 
    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = {1, 2, 5}; // Different coin denominations
        int amount = 5; // Amount to make change for
        int result = cc.coinChange(coins, amount);
        System.out.println("Number of ways to make change for " + amount + " using given coins: " + result);
        // Output: Number of ways to make change for 5 using given coins: 4
    }
    
}
