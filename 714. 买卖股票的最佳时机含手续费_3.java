class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int dp_0 = 0, dp_1 = -prices[0];

        for (int price : prices) {
            int temp = dp_0;
            dp_0 = Math.max(dp_0,dp_1+price-fee);
            dp_1 = Math.max(dp_1,temp-price);
        }
        return dp_0;
    }
}