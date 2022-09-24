/*
 * @lc app=leetcode.cn id=68 lang=java
 *
 * [68] 文本左右对齐
 */

class Solution {

    //对每行单词进行空格平均划分
    private String fillWords(String[] words, int begin, int end, int maxWidth, boolean lastLine) {
        int wordCount = end - begin + 1;
        // 除去每个单词尾部空格， + 1 是最后一个单词的尾部空格的特殊处理
        int spaceCount = maxWidth + 1 - wordCount;
        for (int i = begin; i <= end; i++) {
            // 除去所有单词的长度
            spaceCount -= words[i].length();
        }
        // 每个词后面跟的空格
        int spaceSuffix = 1;
        // 额外空格的平均值 = 总空格数/间隙数
        int spaceAvg = (wordCount == 1) ? 1 : spaceCount / (wordCount - 1);    //如果只有一个字符，那么就只有一个坑；否则有(wordCount - 1)个坑，每个坑至少有spaceCount / (wordCount - 1)个空格
        // 额外空格的余数
        int spaceExtra = (wordCount == 1) ? 0 : spaceCount % (wordCount - 1);   //除去平均分配的空格，还有一些多的空格，如果只有一个字符，那不存在额外的空格；反之有spaceCount % (wordCount - 1)个空格
        // 填入单词
        StringBuilder sb = new StringBuilder();
        //如果是只有一个单词，也就是begin==end，这个循环就进不去了
        for (int i = begin; i < end; i++) {
            sb.append(words[i]);
            if (lastLine) {      //如果是最后一行，每个字符串之间都只有一个空格
                sb.append(" ");
                continue;
            }
            //如果不是最后一行，则需要再每个字符串后面添加一些空格
            int n = spaceSuffix + spaceAvg + (((i - begin) < spaceExtra) ? 1 : 0);   //spaceSuffix表示本就该有的，spaceAvg表示每个坑必须至少有的空格数，可能还需要加上额外的空格
            //加上n个空格
            while (n-- > 0) {
                sb.append(" ");
            }
        }
        // 填入最后一个单词
        sb.append(words[end]);
        // 补上这一行最后的空格
        int lastSpaceCnt = maxWidth - sb.length();       //对于只有一个单词的只需要填入单词，如果maxWidth - sb.length()还有空格则填入对于空格
        while (lastSpaceCnt -- > 0){
            sb.append(" ");
        }
        return sb.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int cnt = 0, begin = 0;     //cnt记录长度，begin记录字符串开始位置
        for (int i = 0; i < words.length; i++) {
            cnt += words[i].length() + 1;
            // 如果是最后一个单词，或者加上下一个词就超过长度了，即可凑成一行
            if (i + 1 == words.length || cnt + words[i + 1].length() > maxWidth) {
                // 对每行单词进行空格平均划分
                res.add(fillWords(words, begin, i, maxWidth, i + 1 == words.length));
                begin = i + 1;
                cnt = 0;
            }
        }
        return res;
    }
}
// @lc code=end

