package world.coding.challenges.leetcode.challenge30days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        if (n < 2) return maxProfit;
        int buy = prices[0];
        List<Integer> profitableSellingDays = findProfitableSellingDays(buy, prices, 1, n);
        if (profitableSellingDays.size()==0){
            maxProfit = maxProfit(Arrays.copyOfRange(prices,1,n));
        } else{
            for (int profitableSellingDay : profitableSellingDays){
                int profit = prices[profitableSellingDay] - buy;
                profit += maxProfit(Arrays.copyOfRange(prices,profitableSellingDay+1, n));
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    private List<Integer> findProfitableSellingDays(int buy, int[] prices, int start, int end) {
        List<Integer> output = new ArrayList<>();
        for (int i=start;i<end; i++){
            if (prices[i] > buy) output.add(i);
        }
        return output;
    }

}
