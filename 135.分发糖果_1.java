/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start

//[1,3,2,2,1]   1 2 1 2 1
//[1,2,87,87,87,2,1]   1 2 3 1 3 2 1 

class Solution {

    public static int getcandy(int[] ratings, int[] tang, int i) {
        if (tang[i] != 0) {
            return tang[i];
        }
        int len = ratings.length;
        if (len == 1) {
            tang[i] = 1;
            return tang[i];
        }
        else {
            if (i==0) {
                if (ratings[i] > ratings[i+1]) {
                    tang[i] = getcandy(ratings,tang,i+1) + 1;
                }
                else {
                    tang[i] = 1;
                }
            }
            else if (i==len-1) {
                if (ratings[i] > ratings[i-1]) {
                    tang[i] = getcandy(ratings,tang,i-1) + 1;
                }
                else {
                    tang[i] = 1;
                }
            }
            else {
                if (ratings[i]>ratings[i-1] && ratings[i]>ratings[i+1]) {
                    tang[i] = Math.max(getcandy(ratings,tang,i-1), getcandy(ratings,tang,i+1)) + 1;
                }
                else if (ratings[i] > ratings[i-1]) {
                    tang[i] = getcandy(ratings,tang,i-1) + 1;
                }
                else if (ratings[i] > ratings[i+1]) {
                    tang[i] = getcandy(ratings,tang,i+1) + 1;
                }
                else if (ratings[i]<=ratings[i-1] && ratings[i]<=ratings[i+1]) {
                    tang[i] = 1;
                }
            }
        }
        return tang[i];
    }

    public int candy(int[] ratings) {

        int len = ratings.length;
        int[] tang = new int[len];
        int sum = 0;

        for (int i=0;i<len;i++) {
            tang[i] = 0;
        }
        for (int i=0;i<len;i++) {
            tang[i] = getcandy(ratings, tang, i);
            sum += tang[i];
        }

        return sum;

    }
}
// @lc code=end

