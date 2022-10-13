class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==0) {
            return 0;
        }
        int dp0 = 0, dp1 = nums[0];

        for (int i=2;i<=n;i++) {
            int temp = Math.max(dp1,dp0+nums[i-1]);
            dp0 = dp1;
            dp1 = temp;
        }
        return dp1;

    }
}