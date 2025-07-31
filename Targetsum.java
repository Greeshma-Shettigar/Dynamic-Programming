public class Targetsum {
    public boolean targetsum(int num[], int sum){
        int n=num.length; // Number of elements in the array
        boolean [][] dp = new boolean[n + 1][sum + 1]; // DP array for memoization
        for(int i=0;i<=n;i++){
            dp[i][0] = true; // Base case: sum 0 can always be achieved with no elements
    }
    for(int i=1;i<n+1;i++){
        for(int j=0;j<sum+1;j++){
            int v=num[i-1]; // Current element
            if(j>=v&&dp[i-1][j-v]== true){
                dp[i][j]=true; // If current element can be included to achieve the sum{
                 
            }else if(dp[i-1][j]==true){
                dp[i][j]=true; // If the previous row can achieve the sum, carry it forward
            }
        }
    }
    return dp[n][sum]; // Return the result for the entire array and target sum
    }
    public static void main(String[] args) {
        Targetsum ts = new Targetsum();
        int[] num = {1, 2, 3, 4, 5}; // Array of numbers
        int targetSum = 9; // Target sum to check
        boolean result = ts.targetsum(num, targetSum);
        System.out.println("Can the target sum be achieved? " + result);
        // Output: Can the target sum be achieved? true
    }
    
}
