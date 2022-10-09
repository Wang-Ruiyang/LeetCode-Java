class Solution {
    public int scoreOfParentheses(String s) {
        s = s.replace("()","1");
        int l = 0;
        int sum = 0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)=='(') {
                l++;
            }
            else if (s.charAt(i)==')') {
                l--;
            }
            else if (s.charAt(i)=='1') {
                sum += 1 << l;
            }
        }
        return sum;
    }
}