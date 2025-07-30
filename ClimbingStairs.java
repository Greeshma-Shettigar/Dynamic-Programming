/*Count ways to reach the nth stair .The person can climb either 1  stair or 2 stair at a time */
//using memeoization
class ClimbingStairs {
    public int Climb(int n, int f[]){
        if(n==0) return 1; // Base case: 1 way to stay at the ground
        if(n < 0) return 0; // No way to climb negative stairs
        if(f[n] != -1) return f[n];
       /*for(int i=3;i<n;i++){
       f[i]=f[i-1]+f[i-2]
       } */ 
        f[n] = Climb(n - 1, f) + Climb(n - 2, f);
        // Store the result in the array to avoid recomputation
        return f[n];
    }
   public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        int n = 5; // Example input
        int[] f = new int[n + 1]; // Array to store results
        int result = cs.Climb(n, f);
        System.out.println("Number of ways to climb " + n + " stairs: " + result);
        // Output: Number of ways to climb 10 stairs: 89    
   }
    }   

    // using tabulation
    /*public int Climb(int n){
    int[] dp = new int[n + 1];
    dp[0] = 1; // Base case: 1 way to stay at the ground
    for(int i=1;i<=n;i++){
      if(i==1){
      dp{i] = dp[i - 1]; // Only one way to climb 1 stair
      } else {
        dp[i] = dp[i - 1] + dp[i - 2]; // Sum of ways to climb (i-1) and (i-2) stairs
        }
      }
    return dp[n];
    }
    */