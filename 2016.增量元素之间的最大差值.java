class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int res = -1;
        for (int i=0;i<n;i++) {
            //如果是3...2...10，在以3作为最小的时候已经记录了它的res，当遇到2时，min变成2，这样能扩大距离，因为如果是3-10，一定没有2-10大
            if (nums[i]>min) {
                res = Math.max(res,nums[i]-min);
            }
            else {
                min = Math.min(min,nums[i]);
            }
        }
        return res;
    }
}