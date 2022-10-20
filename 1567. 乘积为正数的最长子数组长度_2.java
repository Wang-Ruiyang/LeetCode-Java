class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[] zs = new int[n];    //记录以当前下标i结尾的乘积为正数的长度
        int[] fs = new int[n];    //记录以当前下标i结尾的乘积为负数的长度

        if (nums[0]>0) {
            zs[0] = 1;
        }
        else if (nums[0]<0){
            fs[0] = 1;
        }
        //如果是0，那么zs和fs都是0

        int max = zs[0];

        for (int i=1;i<n;i++) {
            if (nums[i]>0) {
                //连续正数的个数+1
                zs[i] = zs[i-1] + 1;
                //当前数为正数
                if (fs[i-1]==0) {    //如果在此之前都没有能成为负数的乘积，再加上这个正数，负数长度仍然为0
                    fs[i] = 0;
                }
                else {
                    fs[i] = fs[i-1] + 1;
                }
            }
            else if (nums[i]<0) {
                if (fs[i-1]==0) {
                    zs[i] = 0;
                }
                else {
                    zs[i] = fs[i-1] + 1;
                }
                fs[i] = zs[i-1] + 1;
            }
            else {
                zs[i] = 0;
                fs[i] = 0;
            }
            max = Math.max(max,zs[i]);
        }

        return max;

    }
}