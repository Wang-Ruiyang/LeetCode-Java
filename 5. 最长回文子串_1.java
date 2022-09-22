class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int[] sta = new int[len];
        int maxlen = -9999;
        int maxl=0;     //最长回文子串的左下标
        int maxr=0;     //最长回文子串的右下标

        char[] sarray = new char[len];
        sarray = s.toCharArray();    //将字符串转为字符数组

        //以每个字符为中心，对两边进行扫描
        for (int i=0;i<len;i++) {
            int left = i;
            int right = i;
            boolean ltrue = true;     //左边没有越界且与左边相等
            boolean rtrue = true;     //右边没有越界且与右边相等

            //判断回文子串所有字符都相同
            while (true) {
                if (right<len-1) { 
                    if (sarray[i]== sarray[right+1]) {
                        right++;
                    }
                    else {       //i坐标值与right+1的不同，则返回rtrue = false
                        rtrue = false;
                    }
                }
                else {
                    rtrue = false;    //越界，返回rtrue = false
                }
                if (left>0) {
                    if (sarray[left-1] == sarray[i]) {
                        left--;
                    }
                    else {
                        ltrue = false;
                    }
                }
                else {
                    ltrue = false;
                }
                if (ltrue==false && rtrue==false) {
                    break;
                }
            }
            
            //左右同时扩充
            while (left>0 && right<len-1) {
                if (sarray[left-1] == sarray[right+1]) {
                    left = left-1;
                    right = right+1;
                }
                else {
                    break;
                }
            }
            //对比当前子串，记录数据
            if (right-left+1>maxlen) {
                maxlen = right-left+1;
                maxl = left;
                maxr = right;
            }
        }
        return s.substring(maxl,maxr+1);   //substring为[)
    }
}