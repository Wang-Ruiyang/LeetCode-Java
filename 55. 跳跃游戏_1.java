class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n==1) {
            return true;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i=0;i<n;i++) {
            if (dp[i]==0) {
                return false;
            }
            for (int j=1;j<=nums[i];j++) {
                if (i+j==n-1) {
                    return true;
                }
                dp[i+j] = 1;
            }
        }
        return true;
    }
}