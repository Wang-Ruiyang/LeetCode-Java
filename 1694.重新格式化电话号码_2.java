/*
 * @lc app=leetcode.cn id=1694 lang=java
 *
 * [1694] 重新格式化电话号码
 */

// @lc code=start
class Solution {
    public String reformatNumber(String number) {
        number = number.replace("-","").replace(" ","");

        StringBuilder sb = new StringBuilder();

        for (int i=0;i<number.length();i=i+3) {    //相当于三个一组
            //如果是第一组，前面不加-
            if (sb.length() != 0) {
                sb.append("-");
            }
            //当最后一组只有2个时（此时i定位的是倒数第二组）
            if (i+2==number.length()) {
                sb.append(number.substring(i));
                break;
            }
            //当最后一组只有1个时（此时i定位的是倒数第二组）
            else if (i+4==number.length()) {    //如果最后一组是1个，则最后两组都会进去
                sb.append(number.substring(i,i+2)).append("-").append(number.substring(i+2));
                break;
            }
            sb.append(number.substring(i,i+3));
        }
        return sb.toString();
    }
}
// @lc code=end

