class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        boolean isFind = false;
        for (int i=0;i<n;i++) {
            if (s.charAt(i) == '1' && !isFind) {
                continue;
            }
            else if (s.charAt(i) == '1' && isFind) {
                return false;
            }
            else if (s.charAt(i) == '0') {
                isFind = true;
            }
        }
        return true;
    }
}