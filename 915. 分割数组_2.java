class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;

        int[] min = new int[n];      //i及其以后的区域的最小值
        min[n-1] = nums[n-1];
        for (int i=n-2;i>=0;i--) {
            min[i] = Math.min(nums[i],min[i+1]);
        }

        int max = nums[0];       //表示以当前结尾的前面部分的最大值
        for (int i=0;i<n;i++) {
            max = Math.max(max,nums[i]);
            if (max <= min[i+1]) {     //如果以当前结尾区域最大值 大于 以下一个值开始区域的最小值
                return i+1;
            }
        }
        return -1;
    }
}