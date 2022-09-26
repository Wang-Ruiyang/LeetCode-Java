class Solution {
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        int truesum = (1+n)*n/2;     //n个数之和
        int currentsum = 0;
        for (int num : nums) {       //nums中n-2个数之和
            currentsum += num;
        }
        int x = truesum - currentsum;    //x1+x2
        int t = x / 2;    //一定有一个数比t小，一定有一个数比t大
        truesum = (1+t)*t/2;    //1~t的真实和
        for (int num : nums) {
            if (num <= t) {
                truesum -= num;
            }
        }
        int x1 = truesum;
        int x2 = x - x1;

        return new int[]{x1,x2};
    }
}