public class Knapsack {
    public int knapsack(int va[],int wt[],int W, int n , int dp[][]){
        if(W==0 || n==0) return 0; // Base case: no items or no capacity
        if(dp[n][W] != -1) return dp[n][W]; // Check if already computed
         if(wt[n-1]<=W){
            // Include the last item and check the remaining capacity
            int include = va[n-1] + knapsack(va, wt, W - wt[n-1], n - 1,dp);
            // Exclude the last item and check without it
            int exclude = knapsack(va, wt, W, n - 1,dp);
            dp[n][W] = Math.max(include, exclude);
            return dp[n][W] ;// Return the maximum of both choices
    }else {
            // If the last item's weight exceeds the capacity, skip it
            dp[n][W]= knapsack(va, wt, W, n - 1,dp);
            return dp[n][W]; // Return the value without including the last item
        }
    }
    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] values = {60, 100, 120}; // Values of items
        int[] weights = {10, 20, 30}; // Weights of items
        int capacity = 50; // Maximum weight capacity of the knapsack
        int n = values.length; // Number of items
        int[][] dp = new int[n + 1][capacity + 1]; // DP array for memoization
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1; // Initialize the DP array with -1
            }
        
    }
   int maxValue = ks.knapsack(values, weights, capacity, n,dp);
         
        System.out.println("Maximum value in Knapsack = " + maxValue);
        // Output: Maximum value in Knapsack = 220 
}
}

// Using Tabulation method
/*public int knapsack(int va[],int wt[],int W, int n){
    int[][] dp = new int[n + 1][W + 1]; // DP array for tabulation
    for(int i=0;i<=n;i++){
        for(int j=0;j<=W;j++){
            if(i==0 || j==0) {
                dp[i][j] = 0; // Base case: no items or no capacity
            } else if(wt[i-1] <= j) {
                // Include the last item and check the remaining capacity
                dp[i][j] = Math.max(va[i-1] + dp[i-1][j - wt[i-1]], dp[i-1][j]);
            } else {
                // If the last item's weight exceeds the capacity, skip it
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    return dp[n][W]; // Return the maximum value in the knapsack
}
*/  
