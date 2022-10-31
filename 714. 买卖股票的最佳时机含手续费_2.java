class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        //dp[i][0]表示i天结束后手上没有股票的最大收益
        //dp[i][1]表示i天结束后手上有一张股票的最大收益

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i=1;i<n;i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }

        return dp[n-1][0];

    }
}