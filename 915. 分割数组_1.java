class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int loc = -1;
        int start = 0;
        int min = -1;
        int max = nums[0];

        while (max > min) {

            start = loc+1;
            int mi = nums[start];
            loc = start;
            //找到剩下的最小的节点的位置
            for (int i=start;i<n;i++) {
                if (nums[i]<mi) {
                    mi = nums[i];
                    loc = i;
                }
            }
            //在最小的数的左边找到最大的
            for (int i=start;i<=loc;i++) {
                max = Math.max(max,nums[i]);
            }
            //在最小的右边找到最小的
            min = nums[loc+1];
            for (int i=loc+1;i<n;i++) {
                min = Math.min(min,nums[i]);
            }
        }

        return loc+1;

    }
}