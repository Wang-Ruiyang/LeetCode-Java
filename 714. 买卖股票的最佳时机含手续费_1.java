class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int left = prices[0];
        int sum = 0;
        for (int i=1;i<n;i++) {
            if (prices[i]<left) {   // prices[i]+fee < left+fee
                left = prices[i];
            }
            else if (prices[i]>left+fee) {    //如果后面的减去left和fee依然有收益，那就可以尝试将股票卖出
                sum += prices[i]-left-fee;

                //但是为了防止遇到的是局部最优：
                // left       prices[i]          prices[i+1]
                //实际上的真实收益应该是：prices[i+1]-left-free
                // prices[i]-left-free    + 一个收益   =   prices[i+1]-left-free
                // 解得这个收益为：prices[i+1]-prices[i]
                // 但是 sum += prices[i+1]-prices[i]-fee;，所以left应该设定为prices[i]-fee

                left = prices[i]-fee;
            }
        }
        return sum;
    }
}