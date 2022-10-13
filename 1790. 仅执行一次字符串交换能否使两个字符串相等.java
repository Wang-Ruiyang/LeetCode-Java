class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int l1 = -1, l2 = -1;
        int sum = 0;
        for (int i=0;i<n;i++) {
            if (s1.charAt(i)!=s2.charAt(i)) {
                if (l1==-1) {
                    l1 = i;
                }
                else {
                    l2 = i;
                }
                sum ++;
            }
            if (sum > 2) {
                return false;
            }
        }
        if (sum == 0) {
            return true;
        }
        if (sum != 2) {
            return false;
        }
        if (s1.charAt(l1)==s2.charAt(l2) && s1.charAt(l2)==s2.charAt(l1)) {
            return true;
        }
        else {
            return false;
        }

    }
}