/*Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.Determine the maximum value obtainable by cutting up thr rod and selling the price */
public class RoadCutting {
    public static int roadcutting(int[] price, int[] lengths ,int totRod){
        int n= price.length;
        int[][] dp = new int[n+1][totRod+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=totRod; j++){
                if(i== 0||j==0){
                    dp[i][j]=0;
                }
                else{
                    if(lengths[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],price[i-1]+dp[i][j-lengths[i-1]]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
                } 
            }
        }
        return dp[n][totRod];
    }
  public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10}; // Prices for each length
        int[] lengths = {1, 2, 3, 4, 5}; // Lengths of the rods
        int totalRod = 5; // Total length of the rod to cut
        int maxProfit = roadcutting(price, lengths, totalRod);
        System.out.println("Maximum profit from road cutting = " + maxProfit);
        // Output: Maximum profit from road cutting = 12
    }
}
