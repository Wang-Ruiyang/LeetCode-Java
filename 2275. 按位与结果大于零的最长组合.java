class Solution {
    public int largestCombination(int[] candidates) {
        //1e7<2^25
        int[] times = new int[25];
        int n = candidates.length;
        //分别处理每一个数字
        for (int i=0;i<n;i++) {
            int num = candidates[i];
            int j = 0;
            //提取数字的每一位
            while (num!=0) {
                //将 1 位存起来
                if ((num & 1)!=0) {
                    times[j]++;
                }
                num = num >> 1;   //每次num的二进制向右移动一位
                j++;
            }
        }
        int res = -1;
        //如果某一位的1有y个，那么说明在这n个数中一定会有y个数，他们'且'后这一位为1（即结果不为0）
        for (int i=0;i<25;i++) {
            res = Math.max(res,times[i]);
        }
        return res;
    }
}