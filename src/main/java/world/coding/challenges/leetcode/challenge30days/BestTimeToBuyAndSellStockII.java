package world.coding.challenges.leetcode.challenge30days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int maxP = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            maxP = Math.max(maxP, maxProfitUtil(Arrays.copyOfRange(prices, i, prices.length)));
        }
        return maxP;
    }

    public int maxProfitUtil(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        if (n < 2)
            return maxProfit;
        int i = 0;

        maxProfit = 0;
        int buy = prices[i];
        List<Integer> profitableSellingDays = findProfitableSellingDays(buy, prices, i + 1, n);
        if (profitableSellingDays.size() == 0) {
            int[] rest = Arrays.copyOfRange(prices, i + 1, n);
            maxProfit = maxProfitUtil(rest);
        } else {
            for (int profitableSellingDay : profitableSellingDays) {
                int sell = prices[profitableSellingDay];
                int[] rest = Arrays.copyOfRange(prices, profitableSellingDay + 1, n);
                int profit = sell - buy + maxProfitUtil(rest);
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
