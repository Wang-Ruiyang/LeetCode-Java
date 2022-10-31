class Solution {
    public static int MOD = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];    //对于下标为i的辐射左范围为left[i]+1（left[i]不在范围内）
        int[] right = new int[n];

        Deque<Integer> dq = new ArrayDeque<Integer>();

        for (int i=0;i<n;i++) {
            while (!dq.isEmpty() && arr[i]<arr[dq.peekLast()]) {
                dq.pollLast();
            }
            if (dq.isEmpty()) {
                left[i] = -1;
            }
            else {
                left[i] = dq.peekLast();
            }
            dq.addLast(i);
        }

        dq.clear();
        for (int i=n-1;i>=0;i--) {
            while (!dq.isEmpty() && arr[i]<=arr[dq.peekLast()]) {
                dq.pollLast();
            }
            if (dq.isEmpty()) {
                right[i] = n;
            }
            else {
                right[i] = dq.peekLast();
            }
            dq.addLast(i);
        }

        // 3 4 1 2 5 6
        // 对于1的辐射范围，左边范围长度为3，右边为4
        // 1, 41, 12, 341, 412, 125, 3412, 4125, 1256, 34125, 41256, 341256，共12个
        // 对于4的辐射范围，左边范围长度为1，右边为1
        // 4，共1个
        // 对于6的辐射范围，左边范围长度为1，右边为1
        // 6，共1个

        long sum =0;
        for (int i=0;i<n;i++) {
            sum = (sum + (long)arr[i] * (i-left[i]) * (right[i]-i)) % MOD;
        }

        return (int)sum;
    }
}