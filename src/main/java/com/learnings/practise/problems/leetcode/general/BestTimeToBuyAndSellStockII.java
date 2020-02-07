package com.learnings.practise.problems.leetcode.general;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;

        int totalProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1])
                totalProfit += prices[i] - prices[i-1];
        }
        return totalProfit;
    }
}