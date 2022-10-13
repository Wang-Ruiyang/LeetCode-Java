class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int min = n, max = -1;
        int res = 0;
        for (int i = 0, j = 0; i < n; i++) {     //i表示右边界
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
            if (min == j && max == i) {
                res ++;
                j = max+1;
                min = n;
                max = -1;
            }
        }
        return res;

    }
}