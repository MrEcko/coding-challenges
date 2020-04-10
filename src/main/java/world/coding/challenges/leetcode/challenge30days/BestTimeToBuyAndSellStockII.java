package world.coding.challenges.leetcode.challenge30days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int[] computedMaxProfits = new int[prices.length+1];
        Arrays.fill(computedMaxProfits, -1);
        return maxProfitUtil(prices, 0,computedMaxProfits);
    }

    public int maxProfitUtil(int[] prices, int start, int[] computedMaxProfits) {
        int maxProfit = 0;
        if (prices.length - start < 2)
            return maxProfit;

        for (int buyingDay = start; buyingDay < prices.length - 1; buyingDay++) {
            List<Integer> profitableSellingDays = findProfitableSellingDays(buyingDay, prices);
            if (profitableSellingDays.size() == 0) {
                int maxProfitOnRemainingDays;
                if (computedMaxProfits[buyingDay + 1] == -1){
                    maxProfitOnRemainingDays = maxProfitUtil(prices, buyingDay + 1,computedMaxProfits);
                    computedMaxProfits[buyingDay + 1] = maxProfitOnRemainingDays;
                } else {
                    maxProfitOnRemainingDays = computedMaxProfits[buyingDay + 1];
                }
                maxProfit = Math.max(maxProfit, maxProfitOnRemainingDays);
            } else {
                for (int profitableSellingDay : profitableSellingDays) {
                    int maxProfitOnRemainingDays;
                    if (computedMaxProfits[profitableSellingDay + 1] == -1){
                        maxProfitOnRemainingDays = maxProfitUtil(prices, profitableSellingDay + 1,computedMaxProfits);
                        computedMaxProfits[profitableSellingDay + 1] = maxProfitOnRemainingDays;
                    } else{
                        maxProfitOnRemainingDays = computedMaxProfits[profitableSellingDay + 1];
                    }
                    int profit = prices[profitableSellingDay] - prices[buyingDay] + maxProfitOnRemainingDays;
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
