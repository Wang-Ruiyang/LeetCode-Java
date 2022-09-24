/*
 * @lc app=leetcode.cn id=68 lang=java
 *
 * [68] 文本左右对齐
 */

// @lc code=start
class Solution {

    public static void addk(StringBuffer sb,int le) {
        for (int t=0;t<le;t++) {
            sb.append(" ");
        }
    }

    public static void initial(String[] words,StringBuffer sb,int start,int end) {
        for (int t = start;t<=end;t++) {
            sb.append(words[t]);
            sb.append(" ");
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;
        System.out.println(len);
        int start = 0;     //每一行的起始位置
        int wordslen = 0;
        int reallen = 0;
        List<String> ls = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        boolean isFine = false;     //表示还没有找到
        for (int i=0;i<len;i++) {
            if (wordslen==0) {
                start = i;
            }
            int l = i - start;
            if (wordslen+words[i].length()+1 <= maxWidth) {   //每个元素后面都加一个空格
                wordslen += words[i].length()+1;    //当前字符串的长度
                reallen += words[i].length();
                if (i == len-1) {    //在最大长度范围内，且i元素是最后一个元素，截断最后一部分
                    initial(words, sb, start, i);
                    addk(sb,(maxWidth-wordslen));
                    isFine = true;
                }
            }
            else {     //加上i的字符串已经超过了最大长度
                //表示i字符串能要，对于i元素，如果不加空格可以收入，此时i元素可以成立
                if (wordslen+words[i].length() == maxWidth) {
                    wordslen += words[i].length();
                    reallen += words[i].length();
                    int lo = maxWidth - reallen;

                    //不止一个元素
                    if (l!=0) {
                        if (l==1) {    //有2个元素
                            sb.append(words[start]);
                            addk(sb, lo);
                        }
                        else {    //不止一个元素
                            if (lo%l == 0) {
                                for (int j=start;j<i;j++) {
                                    sb.append(words[j]);
                                    addk(sb,(lo/l));
                                }
                            }
                            else {
                                int k = lo%l;
                                for (int j=start;j<i;j++) {
                                    sb.append(words[j]);
                                    if (k>0) {
                                        addk(sb,(lo/l)+1);
                                        k--;
                                    }
                                    else {
                                        addk(sb,(lo/l));
                                    }

                                }
                            }
                        }
                    }
                    //一个元素且刚好填满maxWidth的直接加入
                    sb.append(words[i]);     //最后一个右边不空
                }
                //表示i位置的字符串不能要
                else {
                    l = l-1;     //空格坑的个数
                    if (l==0) {     //1个元素
                        sb.append(words[start]);
                        addk(sb,(maxWidth-reallen));
                    }
                    else {
                        if (l==1) {    //有2个元素
                            int lo = maxWidth-reallen;    //空格数
                            sb.append(words[start]);
                            addk(sb,lo);
                        }
                        else {    //不止一个元素
                            int lo = maxWidth-reallen;    //空格数
                            if (lo%l == 0) {
                                for (int j=start;j<i-1;j++) {
                                    sb.append(words[j]);
                                    addk(sb,(lo/l));
                                }
                            }
                            else {
                                int k = lo%l;
                                for (int j=start;j<i-1;j++) {
                                    sb.append(words[j]);
                                    if (k>0) {
                                        addk(sb,(lo/l)+1);
                                        k--;
                                    }
                                    else {
                                        addk(sb,(lo/l));
                                    }

                                }
                            }
                        }
                        sb.append(words[i-1]);     //最后一个右边不空
                    }
                    i--;
                }
                isFine = true;

            }
            if (isFine) {
                ls.add(new String(sb));
                sb.setLength(0);
                wordslen = 0;
                reallen = 0;
                isFine = false;
            }
        }
        return ls;
    }
}
// @lc code=end

