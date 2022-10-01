/*
 * @lc app=leetcode.cn id=1694 lang=java
 *
 * [1694] 重新格式化电话号码
 */

// @lc code=start
class Solution {
    public String reformatNumber(String number) {
        int i = 0;
        //删字符
        while(i < number.length()) {
            if (number.charAt(i) == ' ' || number.charAt(i)=='-') {
                if (i!=number.length()-1) {
                    number = number.substring(0,i) + number.substring(i+1);
                }
                else {
                    number = number.substring(0,i);
                }
                i--;
            }
            i++;
        }

        int k = number.length()/3;
        int t = number.length()%3;
        if (t!=0) {    //4个，分两个
            k++;
        }
        //一共k个分组，k-1个-
        //123-4567, k=3

        int j = 0;
        for (i=1;i<k;i++) {
            if (i==k-1 && t==1) {
                number = number.substring(0, j+2) + '-' + number.substring(j+2);
                j = j + 3;
            }
            else {
                number = number.substring(0, j+3) + '-' + number.substring(j+3);
                j = j + 4;

            }

        }
        return number;
    }
}
// @lc code=end

