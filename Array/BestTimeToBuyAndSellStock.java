// Problem: Best Time to Buy and Sell Stock
// Difficulty: Easy
// Topic: Arrays
// LeetCode Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            // profit if sold today
            int profit = prices[i] - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }

            // update cheapest price
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

        int[] test1 = {7, 1, 5, 3, 6, 4};
        int[] test2 = {7, 6, 4, 3, 1};
        int[] test3 = {5}; // edge case

        System.out.println("Test 1: " + solution.maxProfit(test1));
        System.out.println("Test 2: " + solution.maxProfit(test2));
        System.out.println("Test 3: " + solution.maxProfit(test3));
    }
}