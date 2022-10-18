class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i=0;i<n;i++) {
            if (i!=0 && dp[i]==0) {
                return 0;
            }
            for (int j=1;j<=nums[i];j++) {
                if (i+j<n) {
                    if (dp[i+j]==0) {
                        dp[i+j] = dp[i]+1;
                    }
                    else {
                        dp[i+j] = Math.min(dp[i]+1,dp[i+j]);
                    }

                }
                else {
                    break;
                }
            }
        }
        return dp[n-1];
    }
}