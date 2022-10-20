class Solution {

    public int FindLast(int n,int k) {
        if (n==1) {
            return 0;
        }
        int len = 1 << (n-1);
        if (k<=len/2) {    //在左边
            return FindLast(n-1,k);
        }
        else {      //在右边，那么就得对于上一层的对应位置取反数字
            int t = FindLast(n-1,k-len/2);
            if (t==0) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }

    public int kthGrammar(int n, int k) {
        if (n==1) {
            return 0;
        }
        return FindLast(n,k);
    }
}