class Solution {
    public int maxProfit(int[] prices) {
        // 这题很容易想复杂了，其实这题的目的就是为了始终不亏钱
        // 所以只要是相邻两个升序的就买了就卖，一定能赚一笔！
        int sum = 0;
        for (int i=1;i<prices.length;i++) {
            if (prices[i]>prices[i-1]) {
                sum += prices[i]-prices[i-1];
            }
        }
        return sum;
    }
}