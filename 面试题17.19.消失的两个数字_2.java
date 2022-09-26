
class Solution {
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        int x = 0;      //定义 x = x1 ^ x2

        //将nums中所有元素按位异或（一共n-2个元素）
        for (int num : nums) {
            x = x ^ num;
        }
        //对n个数进行异或，一共2n-2个元素异或，相当于2组n-2元素和2个没有的元素异或
        for (int i=1;i<=n;i++) {
            x = x ^ i;
        }

        int type1 = 0, type2 = 0;
        int l = 0;     //只有一位为1,记作第k位
        if (x == Integer.MIN_VALUE) {
            l = x;
        }
        else {
            l = x & (-x);
        }

        //对nums中n-2个数划分为两部分
        for (int num : nums) {      //第k位为0
            if ((l & num) == 0) {
                type1 = type1 ^ num;
            }
            else {
                type2 = type2 ^ num;
            }
        }

        //对n个数划分为两部分
        for (int i=1;i<=n;i++) {
            if ((l & i) == 0) {
                type1 = type1 ^ i;
            }
            else {
                type2 = type2 ^ i;
            }
        }

        return new int[]{type1,type2};
    }
}