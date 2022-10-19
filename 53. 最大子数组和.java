class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int last = nums[0];
        int max = nums[0];
        for (int i=1;i<n;i++) {
            last = Math.max(last+nums[i],nums[i]);
            max = Math.max(max, last);
        }
        return max;
    }
}