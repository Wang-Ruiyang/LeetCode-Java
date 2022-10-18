class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;        // 上次跳跃可达范围右边界（下次的最右起跳点）
        int max_border = 0;        // 目前能跳到的最远位置
        int step = 0;
        for (int i=0;i<n-1;i++) {
            max_border = Math.max(max_border,i+nums[i]);
            // 到达上次跳跃能到达的右边界了
            if (i == end) {
                end = max_border;    // 目前能跳到的最远位置变成了下次起跳位置的有边界
                step++;    // 进入下一次跳跃
            }
        }
        return step;
    }
}