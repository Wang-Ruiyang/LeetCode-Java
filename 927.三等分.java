/*
 * @lc app=leetcode.cn id=927 lang=java
 *
 * [927] 三等分
 */

// @lc code=start
class Solution {
    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        int num = 0;
        for (int i=0;i<n;i++) {
            if (arr[i] == 1) {
                num++;
            }
        }
        //如果不足3个元素，或者1个个数不是3的倍数
        if(n<3 || num%3!=0) {
            return new int[] {-1,-1};
        }
        //如果满足上面的条件但是全是0
        if (num==0) { 
            return new int[] {0,n-1};
        }
        //对于总共>=3个元素，且含1的数量时3的倍数的
        int[] location = new int[num];
        int j = 0;
        for (int i=0;i<n;i++) {     //记录1出现的位置
            if (arr[i] == 1) {
                location[j] = i;
                j++;
            }
        }
        int k = num/3;     //每一组需要的1的数量
        int t = n-1-location[num-1];    //最后一个1后面的0的数量

        if (k>1) {  //对于每组1的个数大于1的，如果每组只有1个1，那么在上面检查完最后0的数量正常的话，直接输出位置即可
            int p = 0;   //记录每组1的个数
            int x = 0+1, y = k+1, z = 2*k+1;
            while(x<k) {     
                int a = location[x] - location[x-1] -1;    
                int b = location[y] - location[y-1] -1;
                int c = location[z] - location[z-1] -1;
                if (a!=b || a!=c || b!=c) {
                    return new int[] {-1,-1};
                }
                x++;
                y++;
                z++;
            }
        }

        //不论是每组只有1个1还是多个1，都需要判断1后面的0是不是符合条件
        int x = k, y = 2*k;
        int a = location[x] - location[x-1] -1;    
        int b = location[y] - location[y-1] -1;
        if (a<t || b<t) {     //此时x是第二组的第一个，y是第三组的第一个
            return new int[] {-1,-1};
        }

        return new int[] {location[k-1]+t,location[2*k-1]+t+1};     
    }
}
// @lc code=end

