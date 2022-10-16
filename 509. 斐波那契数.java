class Solution {
    public int fib(int n) {
        if (n==0) {
            return 0;
        }
        int a = 0, b = 1;
        int t = 1;
        while (t<n) {
            int temp = b;
            b = a + b;
            a = temp;
            t++;
        }
        return b;
    }
}