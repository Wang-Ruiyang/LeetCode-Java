class Solution {
    public int rob(int[] nums) {

        //其实可以将这个问题拆解为：
        //n(0~n-1)个屋子分别在0~n-2和1~n-1中取最大值，这样就能保证首位不会同时出现

        int n = nums.length;

        if (n==1) {
            return nums[0];
        }

        int[] res = new int[n];

        //0~n-2
        res[0] = 0;
        res[1] = nums[0];
        for (int i=2;i<n;i++) {
            res[i] = Math.max(res[i-1],res[i-2]+nums[i-1]);
        }

        int max = res[n-1];

        //1~n-1
        res[0] = 0;
        res[1] = nums[1];
        for (int i=2;i<n;i++) {
            res[i] = Math.max(res[i-1],res[i-2]+nums[i]);
        }

        max = Math.max(max,res[n-1]);

        return max;

    }
}