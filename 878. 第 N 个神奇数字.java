class Solution {
    public static int gys(int a, int b) {
        if (b==0) {
            return a;
        }
        else {
            return gys(b,a%b);
        }
    }
    public static int gbs(int a, int b) {
        return a*b/gys(a,b);
    }
    public int nthMagicalNumber(int n, int a, int b) {
        int MOD = 1_000_000_007;
        long left = 0;
        long right = (long) Math.max(a,b)*n;     //这里使用max或者min都行，但是max内存消耗更少，因为右边界越大，目标就月靠近中间，能更快找到。如果使用min，反而目标靠近边界，复杂度更高。
        long gbs_num = gbs(a,b);    //找到最小公倍数
        // System.out.println(gbs_num);
        while (left<right) {
            long mid = left + (right-left)/2;

            //核心代码，判断一个数是不是我们要的第n个数
            if (mid/a + mid/b - mid/gbs_num < n) {
                left = mid + 1;
            }
            else {    //注意：当在第n~n+1个数之间的所有数都满足这个条件（因为/只保留了商），因此我们需要找到第一个满足这个条件的数
                right = mid;
            }
        }
        return (int) (left%MOD);    //需要注意：(int)只对后面相邻的数有效，所以别忘了括号。

    }
}