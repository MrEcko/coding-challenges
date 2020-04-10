package world.coding.challenges.leetcode.challenge30days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        return maxProfitUtil(prices, 0);
    }

    public int maxProfitUtil(int[] prices, int start) {
        int maxProfit = 0;
        if (prices.length - start < 2)
            return maxProfit;

        for (int buyingDay = start; buyingDay < prices.length - 1; buyingDay++) {
            List<Integer> profitableSellingDays = findProfitableSellingDays(buyingDay, prices);
            if (profitableSellingDays.size() == 0) {
                maxProfit = Math.max(maxProfit,maxProfitUtil(prices, buyingDay + 1));
            } else {
                for (int profitableSellingDay : profitableSellingDays) {
                    int profit = prices[profitableSellingDay] - prices[buyingDay] + maxProfitUtil(prices, profitableSellingDay + 1);
                    maxProfit = Math.max(maxProfit, profit);
                }
            }
        }
        return maxProfit;
    }

    private List<Integer> findProfitableSellingDays(int buyingDay, int[] prices) {
        List<Integer> output = new ArrayList<>();
        int buyingPrice = prices[buyingDay];
        for (int i = buyingDay+1; i < prices.length; i++) {
            if (prices[i] > buyingPrice) output.add(i);
        }
        return output;
    }

}
