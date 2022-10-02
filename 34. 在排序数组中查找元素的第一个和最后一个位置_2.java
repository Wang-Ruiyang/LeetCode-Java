class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = Search(nums, target);
        int right = Search(nums, target+1)-1;
        if (left >= nums.length || nums[left]!=target || left>right) {
            return new int[]{-1,-1};
        }
        return new int[]{left,right};

    }

    //找到nums中>=ta的第一个值的下标
    public static int Search(int[] nums, int ta) {
        int i = 0, j = nums.length;
        while (i<j) {
            int t = (i+j)/2;
            if (nums[t] >= ta) {
                j = t;
            }
            else {
                i = t+1;
            }
        }
        return i;   //在最后一步的时候，j会在i左边，i和t值是一样的
    }

}