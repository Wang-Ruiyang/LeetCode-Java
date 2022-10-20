class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int a = 0;
        int b = 0;

        if (nums[0]>0) {
            a = 1;
        }
        else if (nums[0]<0){
            b = 1;
        }
        //如果是0，那么zs和fs都是0

        int max = a;

        for (int i=1;i<n;i++) {
            if (nums[i]>0) {
                //连续正数的个数+1
                a = a + 1;
                //当前数为正数
                if (b==0) {    //如果在此之前都没有能成为负数的乘积，再加上这个正数，负数长度仍然为0
                    b = 0;
                }
                else {
                    b = b + 1;
                }
            }
            else if (nums[i]<0) {
                int temp = a;
                if (b==0) {
                    a = 0;
                }
                else {
                    a = b + 1;
                }
                b = temp + 1;
            }
            else {
                a = 0;
                b = 0;
            }
            max = Math.max(max,a);
        }

        return max;

    }
}