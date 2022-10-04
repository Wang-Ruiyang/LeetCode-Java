class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");      //由题目可以知道，只有出现111111000000的情况为正确，其他情况都是错误
    }
}