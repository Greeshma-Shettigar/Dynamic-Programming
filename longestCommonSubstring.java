public class longestCommonSubstring {
    public static int longSubstring(String s1, String s2 ){
        int n=s1.length();
        int m=s2.length();
        int ans=0;
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans=Math.max(ans, dp[i][j]); // Update the maximum length found
                }else{
                    dp[i][j]=0; // Reset to 0 if characters do not match
                }
            }
        }
        return ans; // Return the length of the longest common substring
    }
    public static void main(String[] args) {
        String str1 = "ABABC";
        String str2 = "BABCAB";
        int length = longSubstring(str1, str2);
        System.out.println("Length of Longest Common Substring = " + length);
        // Common substring is "BABC" so Output: Length of Longest Common Substring = 4
    
}
}
