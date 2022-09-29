class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        if (n == 0) {
            return true;
        }
        for (int i=0;i<n;i++) {    // i表示s1字符向左移动的位数
            boolean isTrue = true;
            for (int j=0;j<n;j++) {    //定位s2的当前位置，s2[j] == s1[(i+j)%n]
                if (s2.charAt(j) != s1.charAt((i+j)%n)) {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue == true) {
                return true;
            }
        }
        return false;
    }
}