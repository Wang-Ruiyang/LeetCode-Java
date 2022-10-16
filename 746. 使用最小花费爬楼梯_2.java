class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int a = 0, b = 0, temp = 0;
        for (int i=2;i<=n;i++) {
            temp = Math.min(b+cost[i-1],a+cost[i-2]);
            a = b;
            b = temp;
        }
        return b;
    }
}