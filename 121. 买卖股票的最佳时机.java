class Solution {
    public int maxProfit(int[] prices) {    //与1014题思路一模一样
        int max = 0;
        int l = 10010;
        for (int price:prices) {
            max = Math.max(max,price-l);
            l = Math.min(l,price);
        }
        return max;
    }
}