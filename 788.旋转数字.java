/*
 * @lc app=leetcode.cn id=788 lang=java
 *
 * [788] 旋转数字
 */

//旋转之后与原数不同

// @lc code=start
class Solution {

    public static boolean isFine(int num,int k) {
        int bei = 1;
        for (int t=1;t<k;t++) {
            bei = bei * 10;
        }
        int sum = 0;
        int temp = num;

        int i = 0;
        while (bei!=0) {
            i = temp / bei;

            if (i == 2) {
                sum = sum * 10 + 5;
            }
            else if (i == 5) {
                sum = sum * 10 + 2;
            }
            else if (i == 6) {
                sum = sum * 10 + 9;
            }
            else if (i == 9) {
                sum = sum * 10 + 6;
            }
            else {
                sum = sum * 10 + i;
            }
            temp = temp % bei;
            bei = bei / 10;
        }
        if (sum != num) {
            return true;
        }
        else {
            return false;
        }
    }

    //判断是否为合格的数
    public static boolean isQualified(int num) {

        //205
        int temp = num;
        int i=0;
        int k = 0;
        while (temp!=0) {
            i = temp % 10;
            if (i==3 || i==4 || i==7) {
                return false;
            }
            temp = temp / 10;
            k++;
        }
        if (isFine(num, k)) {
            return true;
        }
        else {
            return false;
        }
    }

    public int rotatedDigits(int n) {
        int sum = 0;  //记录结果
        for (int i =1;i<n+1;i++) {
            if (isQualified(i)) {
                sum ++;
            }
        }
        return sum;
    }
}
// @lc code=end

