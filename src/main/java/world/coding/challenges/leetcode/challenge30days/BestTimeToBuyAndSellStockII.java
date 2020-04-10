package world.coding.challenges.leetcode.challenge30days;

import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int maxP = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            maxP = Math.max(maxP, maxProfitUtil(prices, i));
        }
        return maxP;
    }

    public int maxProfitUtil(int[] prices, int start) {
        int maxProfit = 0;
        int n = prices.length;
        if (n - start < 2)
            return maxProfit;
        int buy = prices[start];
        List<Integer> profitableSellingDays = findProfitableSellingDays(buy, prices, start + 1, n);
        if (profitableSellingDays.size() == 0) {
            return 0;
        } else {
            for (int profitableSellingDay : profitableSellingDays) {
                int sell = prices[profitableSellingDay];
                int profit = sell - buy + maxProfitUtil(prices, profitableSellingDay + 1);
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    private List<Integer> findProfitableSellingDays(int buy, int[] prices, int start, int end) {
        List<Integer> output = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if (prices[i] > buy) output.add(i);
        }
        return output;
    }

}
