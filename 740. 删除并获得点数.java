class Solution {
    public int deleteAndEarn(int[] nums) {

        /*
        分析：
        题目中说的是如果选取i值，就不能选取所有的i-1和i+1
        这看似是涉及到左右，但是实际上只要考虑左边就行了
        考虑每个值选还是不选即可（变成了小偷问题）
        */

        int n = nums.length;
        Arrays.sort(nums);
        int max = nums[n-1];

        //构建次数数组，记录每个值出现的次数，下标就是值
        int[] res = new int[max+1];
        for (int i=0;i<n;i++) {
            res[nums[i]]++;
        }

        //动态规划
        int[] dp = new int[max+2];
        dp[0] = 0;
        dp[1] = res[0];

        for (int i=2;i<max+2;i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+res[i-1]*(i-1));
        }

        return dp[max+1];
    }
}