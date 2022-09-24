/*
 * @lc app=leetcode.cn id=1652 lang=java
 *
 * [1652] 拆炸弹
 */

// @lc code=start
class Solution {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] result = new int[len];
        for (int i=0;i<len;i++) {
            result[i] = 0;
            if (k>0) {
                for (int j=1;j<=k;j++) {
                    result[i] += code[(i+j)%len];
                }
            }
            else if (k<0) {
                for (int j=1;j<=(-k);j++) {
                    //0 1 2 3 4 5
                    if (i-j<0) {
                        result[i] += code[len+(i-j)];
                    }
                    else {
                        result[i] += code[i-j];
                    }
                }
            }
            
        }
        return result;
    }
}
// @lc code=end

