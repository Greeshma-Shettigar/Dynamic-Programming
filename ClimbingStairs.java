class ClimbingStairs {
    public int Climb(int n, int f[]){
        f[1] = 1;
        f[2]=2;
        if(f[n] != 0) return f[n];
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
