class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int[] v = new int[n];
        int[] l = new int[n];
        v[0] = fruits[0];
        l[0] = 1;
        int j = 0;
        for (int i=1;i<n;i++) {
            if (fruits[i]==v[j]) {
                l[j]++;
            }
            else {
                j++;
                v[j] = fruits[i];
                l[j]++;
            }
        }

        int a=v[0],b=v[0];
        int max = l[0];
        int sum = l[0];
        for (int i=1;i<=j;i++) {
            if (v[i]!=a && v[i]!=b) {
                a = v[i-1];
                b = v[i];
                sum = l[i-1] + l[i];
            }
            else {
                sum += l[i];

            }
            max = Math.max(max,sum);
        }

        return max;
    }
}