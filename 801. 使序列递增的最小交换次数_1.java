//F1

class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = 1;

        for (int i=1;i<n;i++){
            if ((nums1[i]>nums1[i-1] && nums2[i]>nums2[i-1]) && (nums1[i]>nums2[i-1] && nums2[i]>nums1[i-1])) {
                dp[i][0] = Math.min(dp[i-1][0],dp[i-1][1]);
                dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1]) + 1;
            }
            else if ((nums1[i]>nums1[i-1] && nums2[i]>nums2[i-1]) && !(nums1[i]>nums2[i-1] && nums2[i]>nums1[i-1])) {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1] + 1;
            }
            else if (!(nums1[i]>nums1[i-1] && nums2[i]>nums2[i-1]) && (nums1[i]>nums2[i-1] && nums2[i]>nums1[i-1])) {
                dp[i][0] = dp[i-1][1];
                dp[i][1] = dp[i-1][0] + 1;
            }
        }
        return Math.min(dp[n-1][0],dp[n-1][1]);
    }
}