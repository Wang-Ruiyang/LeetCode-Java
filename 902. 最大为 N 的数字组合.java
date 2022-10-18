class Solution {

    public int getLength(int n) {
        int l = 1;
        while (n/10!=0) {
            n = n/10;
            l++;
        }
        return l;
    }

    public int Find(int[] di,int k) {     //找<=k的最大的数的下标
        int i=-1, j=di.length-1;
        while (i<j) {
            int mid = (i+j+1)/2;     //向上取整
            if (di[mid]<=k) {
                i = mid;
            }
            else {
                j = mid-1;
            }
        }
        return i;
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {

        //将digits数组转为int数组
        int dl = digits.length;
        int[] di = new int[dl];
        for (int i=0;i<dl;i++) {
            di[i] = Integer.parseInt(digits[i]);
        }

        //将n转为数组
        int nl = getLength(n);
        int[] ni = new int[nl];
        for (int i=nl-1;i>=0;i--) {
            ni[i] = n%10;
            n = n/10;
        }

        int sum = 0;
        int temp = 1;

        //位数比n小的
        for (int i=0;i<nl-1;i++) {
            temp = temp * dl;
            sum += temp;
        }

        //位数和n相同的
        int p = 1;
        for (int i=0;i<nl;i++) {
            int m = Find(di,ni[i]);
            if (m==-1) {    //表示全都比ni[i]大
                break;
            }
            if (di[m] < ni[i]) {
                sum += (m + 1)*(int)Math.pow(dl,(nl-p));
                break;
            }
            else if (di[m] == ni[i]) {   //相等
                sum += (m)*(int)Math.pow(dl,(nl-p));
                if (i==nl-1) {
                    sum++;
                }
            }
            p++;
        }

        return sum;
    }
}