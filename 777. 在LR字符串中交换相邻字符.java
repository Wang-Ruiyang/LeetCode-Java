class Solution {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }
        int n = start.length();
        int i = 0, j = 0;
        while (i<n || j<n) {
            while (i<n && start.charAt(i)=='X') {
                i++;
            }
            while (j<n && end.charAt(j)=='X') {
                j++;
            }
            if (i==n || j==n) {
                return i==j;    //因为每次都是一堆X，处理一组，所以应该同时到达终点
            }
            else{    //都还没到终点
                if (start.charAt(i) == end.charAt(j)) {
                    if (start.charAt(i)=='L' && i<j) {    //L可以左移，因此需要i要大于等于j的位置
                        return false;
                    }
                    if (end.charAt(j)=='R' && i>j) {
                        return false;
                    }
                    i++;
                    j++;
                }
                else {
                    return false;
                }
            }
        }
        return i==j;
    }
}

