 import java.util.*;
public class TargetSumOfUniqueEle {
   


    public static int minUniqueSubsetSum(int[] arr, int target) {
        // Step 1: Get unique elements
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        // Step 2: Convert to array
        Integer[] uniqueArr = set.toArray(new Integer[0]);

        // Step 3: DP array to store min elements to reach each sum
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // base case: 0 elements to get sum 0

        // Step 4: Fill DP
        for (int num : uniqueArr) {
            for (int t = target; t >= num; t--) {
                if (dp[t - num] != Integer.MAX_VALUE) {
                    dp[t] = Math.min(dp[t], dp[t - num] + 1);
                }
            }
        }

        return dp[target] == Integer.MAX_VALUE ? -1 : dp[target];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 7, 5, 3};
        int target = 14;
        int result = minUniqueSubsetSum(arr, target);
        System.out.println("Minimum number of unique elements to reach sum = " + result);
        // Expected: 2 (because 3 + 7 or 5 + 5 (but 5 is only once) → so 3 + 7 works)
    }
}

    

