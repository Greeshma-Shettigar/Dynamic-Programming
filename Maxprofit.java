import java.util.*;
public class Maxprofit {
    public static Long maxProfit(List<Long> pnl, int k) {
        long currprofit = 0;
        long maxprofit = Long.MIN_VALUE;

        long[] prefix = new long[pnl.size()];
        prefix[0] = pnl.get(0);
        for (int i = 1; i < pnl.size(); i++) {
            prefix[i] = prefix[i - 1] + pnl.get(i);
        }

        for (int i = 0; i < pnl.size(); i++) {
            int start = i;
            for (int j = i; j < pnl.size(); j++) {
                int end = j;
                int size = end - start + 1;

                if (size <= k) {
                    currprofit = (start == 0) ? prefix[end] : (prefix[end] - prefix[start - 1]);
                    maxprofit = Math.max(maxprofit, currprofit);
                }
            }
        }

        return maxprofit;
    }
    public static void main(String[] args) {
        List<Long> pnl = Arrays.asList(1L, -2L, 3L, 4L, -1L);
        int k = 3;
        Long result = maxProfit(pnl, k);
        System.out.println("Maximum Profit: " + result);
    }
}
