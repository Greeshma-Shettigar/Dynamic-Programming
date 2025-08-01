/*A subsequence of a string is a new string generated from the original string with some character (can be none)
 * deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde" while "aec" is not.
  */
public class longectCommonSubsequence {

    public static int commonSubsequence(String s1, String s2){
        int n=s1.length();
        int m=s2.length();
        
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j]=0;
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[n][m]; // Return the length of the longest common subsequence
    }
    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        int length = commonSubsequence(str1, str2);
        System.out.println("Length of Longest Common Subsequence = " + length);
        // Common subsequence is GTAB so Output: Length of Longest Common Subsequence = 4 
    }
}
