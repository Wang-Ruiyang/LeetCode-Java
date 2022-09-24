/*
 * @lc app=leetcode.cn id=68 lang=java
 *
 * [68] 文本左右对齐
 */

// @lc code=start
class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;
        System.out.println(len);
        int start = 0;     //每一行的起始位置
        int wordslen = 0;
        int reallen = 0;
        List<String> ls = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<len;i++) {
            if (wordslen==0) {
                start = i;
            }
            if (wordslen+words[i].length()+1 <= maxWidth) {   //每个元素后面都加一个空格
                wordslen += words[i].length()+1;    //当前字符串的长度
                reallen += words[i].length(); 
                if (i == len-1) {    //在最大长度范围内，且i元素是最后一个元素，截断最后一部分
                    int l = i - start;     //l为-1表示只有一个元素
                    for (int t = start;t<=i;t++) {
                        sb.append(words[t]);
                        sb.append(" ");
                    }
                    for (int t=0;t<(maxWidth-wordslen);t++) {
                        sb.append(" ");
                    }
                    String s = new String(sb);
                    ls.add(s);
                    sb.setLength(0);
                    reallen = 0;
                    wordslen = 0;
                }
            }
            else {     //加上i的字符串已经超过了最大长度
                if (wordslen+words[i].length() == maxWidth) {     //对于i元素，如果不加空格可以收入，此时i元素可以成立
                    wordslen += words[i].length();
                    reallen += words[i].length(); 
                    int lo = maxWidth - reallen;
                    int l = i - start;
                    if (l==0) {     //只有当前一个元素
                        ls.add(words[i]);
                    }
                    else {
                        if (l==1) {    //有2个元素
                            sb.append(words[start]);
                            for (int t=0;t<lo;t++) {
                                sb.append(" ");
                            }
                        }
                        else {    //不止一个元素
                            if (lo%l == 0) {
                                for (int j=start;j<i;j++) {
                                    sb.append(words[j]);
                                    for (int t=0;t<(lo/l);t++) {
                                        sb.append(" ");
                                    }
                                }
                            }
                            else {     
                                int k = lo%l;
                                for (int j=start;j<i;j++) {
                                    sb.append(words[j]);
                                    if (k>0) {
                                        for (int t=0;t<(lo/l)+1;t++) {
                                            sb.append(" ");
                                        }
                                        k--;
                                    }
                                    else {
                                        for (int t=0;t<(lo/l);t++) {
                                            sb.append(" ");
                                        }
                                    }
                                    
                                }
                            }
                        }
                        sb.append(words[i]);     //最后一个右边不空
                        String s = new String(sb);
                        ls.add(s);
                        sb.setLength(0);
                    }
                }
                else {     //表示i位置的字符串不能要
                    int l = i-1 - start;     //空格坑的个数
                    if (l==0) {     //1个元素
                        sb.append(words[start]);
                        for (int t=0;t<(maxWidth-reallen);t++) {
                            sb.append(" ");
                        }
                        String s = new String(sb);
                        ls.add(s);
                        sb.setLength(0);
                    }
                    else {
                        if (l==1) {    //有2个元素
                            int lo = maxWidth-reallen;    //空格数
                            sb.append(words[start]);
                            for (int t=0;t<lo;t++) {
                                sb.append(" ");
                            }
                        }
                        else {    //不止一个元素
                            int lo = maxWidth-reallen;    //空格数
                            if (lo%l == 0) {
                                for (int j=start;j<i-1;j++) {
                                    sb.append(words[j]);
                                    for (int t=0;t<(lo/l);t++) {
                                        sb.append(" ");
                                    }
                                }
                            }
                            else {     
                                int k = lo%l;
                                for (int j=start;j<i-1;j++) {
                                    sb.append(words[j]);
                                    if (k>0) {
                                        for (int t=0;t<(lo/l)+1;t++) {
                                            sb.append(" ");
                                        }
                                        k--;
                                    }
                                    else {
                                        for (int t=0;t<(lo/l);t++) {
                                            sb.append(" ");
                                        }
                                    }
                                    
                                }
                            }
                        }  
                        sb.append(words[i-1]);     //最后一个右边不空
                        String s = new String(sb);
                        ls.add(s);
                        sb.setLength(0);
                    }
                    i--;
                }
                wordslen = 0;
                reallen = 0;
                
            }
            
        }
        return ls;
    }
}
// @lc code=end

