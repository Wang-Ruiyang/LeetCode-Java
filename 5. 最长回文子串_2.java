class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        //表示自己到自己是一个回文数
        for (int i=0;i<len;i++) {
            dp[i][i] = true;
        }

        char[] str = s.toCharArray();
        for (int l=2;l<=len;l++) {    //l是回文子串的长度
            //先查整个s中所有l长度的回文子串
            for (int i=0;i<len;i++) {    //从i为起点长度为l开始遍历
                int j = i + l -1;    //结束下标
                if (j < len) {
                    if (str[i]==str[j]) {
                        if (j-i+1>=3) {   //如果左右端点相等且除去左右端点的字符串也是回文数，则它是回文数（至少有三个元素）
                            dp[i][j] = dp[i+1][j-1];  
                        }
                        else {    //如果左右端点相等且除去左右端点的字符串也是回文数，且小于3个元素时（只能时2个元素，应为l是用2开始的）
                            dp[i][j] = true;    //"aa"
                        }
                    }
                    else {
                        dp[i][j] = false;
                    }
                }
                else {   //越界
                    break;
                }
            }
        }

        int maxlen = -999;
        int maxl = 0;
        int maxr = 0;
        for (int i = 0; i < len; i++) {
            for (int j = len-1; j >=i; j--) {
                if (dp[i][j]==true) {
                    if ((j-i+1) > maxlen) {
                        maxlen = j-i+1;
                        maxl = i;
                        maxr = j;
                    }
                    break;
                }
            }
        }
        return s.substring(maxl,maxr+1);
    }
}