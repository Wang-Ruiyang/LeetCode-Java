class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int lastmax = nums[0], max = nums[0];
        int lastmin = nums[0], min = nums[0];
        int sum = nums[0];
        for (int i=1;i<n;i++) {
            //以当前节点为结尾的最大的连续
            lastmax = Math.max(lastmax+nums[i],nums[i]);
            max = Math.max(lastmax,max);
            //以当前节点为结尾的最小的连续
            lastmin = Math.min(lastmin+nums[i],nums[i]);
            min = Math.min(lastmin,min);
            sum += nums[i];
        }
        if (max<0) {    //如果max都已经小于0，说明整个nums数组的元素都是小于0的，那么直接输出max即可
            return max;
        }
        else {    //如果数组中存在正数，那么输出max和sum-min中的最大值
            return Math.max(max,sum-min);
        }
    }
}