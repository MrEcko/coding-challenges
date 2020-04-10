package world.coding.challenges.leetcode.challenge30days;

import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;

//        recursive:
//        int[] computedMaxProfits = new int[prices.length+1];
//        Arrays.fill(computedMaxProfits, -1);
//        return maxProfitUtil(prices, 0,computedMaxProfits);

    }

    public int maxProfitUtil(int[] prices, int start, int[] computedMaxProfits) {
        int maxProfit = 0;
        if (prices.length - start < 2)
            return maxProfit;

        for (int buyingDay = start; buyingDay < prices.length - 1; buyingDay++) {
            List<Integer> profitableSellingDays = findProfitableSellingDays(buyingDay, prices);
            if (profitableSellingDays.size() == 0) {
                int maxProfitOnRemainingDays;
                int nextBuyingDay = findNextBuyingDay(buyingDay, prices);
                if (nextBuyingDay == -1) break; //no more profits to be made
                if (computedMaxProfits[nextBuyingDay] == -1) {
                    maxProfitOnRemainingDays = maxProfitUtil(prices, nextBuyingDay, computedMaxProfits);
                    computedMaxProfits[nextBuyingDay] = maxProfitOnRemainingDays;
                } else {
                    maxProfitOnRemainingDays = computedMaxProfits[nextBuyingDay];
                }

                maxProfit = Math.max(maxProfit, maxProfitOnRemainingDays);
            } else {
                for (int profitableSellingDay : profitableSellingDays) {
                    int maxProfitOnRemainingDays;
                    if (computedMaxProfits[profitableSellingDay + 1] == -1) {
                        maxProfitOnRemainingDays = maxProfitUtil(prices, profitableSellingDay + 1, computedMaxProfits);
                        computedMaxProfits[profitableSellingDay + 1] = maxProfitOnRemainingDays;
                    } else {
                        maxProfitOnRemainingDays = computedMaxProfits[profitableSellingDay + 1];
                    }
                    int profit = prices[profitableSellingDay] - prices[buyingDay] + maxProfitOnRemainingDays;
                    maxProfit = Math.max(maxProfit, profit);
                }
            }
        }
        return maxProfit;
    }



    /**
     * With this optimisation there is no need to keep recomputing predictable outcomes
     *
     * @return the first decreasing buying price or -1
     */
    private int findNextBuyingDay(int buyingDay, int[] prices) {
        int buyingPrice = prices[buyingDay];
        for (int i = buyingDay + 1; i < prices.length; i++) {
            if (prices[i] < buyingPrice) {
                return i;
            }
        }
        return -1;
    }

    private List<Integer> findProfitableSellingDays(int buyingDay, int[] prices) {
        List<Integer> output = new ArrayList<>();
        int buyingPrice = prices[buyingDay];
        for (int i = buyingDay + 1; i < prices.length; i++) {
            if (prices[i] > buyingPrice) output.add(i);
        }
        return output;
    }

}
