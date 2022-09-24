/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start

//[1,3,2,2,1]   1 2 1 2 1
//[1,2,87,87,87,2,1]   1 2 3 1 3 2 1 

class Solution {

    public int candy(int[] ratings) {

        int len = ratings.length;
        int[] tang = new int[len];
        int sum = 0;

        for (int i=0;i<len;i++) {
            if (i>0 && ratings[i]>ratings[i-1]) {
                tang[i] = tang[i-1] + 1;
            }
            else {
                tang[i] = 1;
            }
        }
        int temp = 0;
        for (int i=len-1;i>=0;i--) {
            if (i<len-1 && ratings[i]>ratings[i+1]) {
                sum += Math.max(tang[i],++temp);
            }
            else {
                temp = 1;
                sum += Math.max(tang[i],temp);
            }
        }

        // //上面循环等效于：
        // for (int i=len-1;i>=0;i--) {
        //     if (i<len-1 && ratings[i]>ratings[i+1]) {
        //         temp++;
        //     }
        //     else {
        //         temp = 1;
        //     }
        //     sum += Math.max(tang[i],temp);
        // }

        return sum;

    }
}
// @lc code=end

