class Solution {
    public int getKthMagicNumber(int k) {
        int [] arrs = new int[k];
        arrs[0] = 1;
        int i3 = 0, i5 = 0, i7 = 0;     //表示*3、*5、*7
        for (int i=1;i<k;i++) {
            int a = arrs[i3]*3, b = arrs[i5]*5, c = arrs[i7]*7;
            int min = Math.min(a, Math.min(b,c));
            if (min == a) {
                i3++;
            }
            if (min == b) {
                i5++;
            }
            if (min == c) {
                i7++;
            }
            arrs[i] = min;
        }
        return arrs[k-1];
    }
}