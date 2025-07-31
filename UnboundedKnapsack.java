public class UnboundedKnapsack {
   public int knapsack(int va[],int wt[],int W, int n){
    int[][] dp = new int[n + 1][W + 1]; // DP array for tabulation
    for(int i=0;i<=n;i++){
        for(int j=0;j<=W;j++){
            if(i==0 || j==0) {
                dp[i][j] = 0; // Base case: no items or no capacity
            } else if(wt[i-1] <= j) {
                // Include the last item and check the remaining capacity
                dp[i][j] = Math.max(va[i-1] + dp[i][j - wt[i-1]], dp[i-1][j]);
            } else {
                // If the last item's weight exceeds the capacity, skip it
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    return dp[n][W]; // Return the maximum value in the knapsack
}
public static void main(String[] args) {
        UnboundedKnapsack uk = new UnboundedKnapsack();
        int[] values = {15,14,10,45,30}; // Values of items
        int[] weights = {2,5,1,3,4}; // Weights of items
        int capacity = 7; // Maximum weight capacity of the knapsack
        int n = values.length; // Number of items
        int maxValue = uk.knapsack(values, weights, capacity, n);
         
        System.out.println("Maximum value in Unbounded Knapsack = " + maxValue);
        // Output: Maximum value in Unbounded Knapsack = 300 
    } 
}
