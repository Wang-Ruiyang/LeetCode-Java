class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preadd = new long[n+1];    //记录当前i以前的元素的和
        for (int i=1;i<n+1;i++) {
            preadd[i] = preadd[i-1] + nums[i-1];     //存的是当前值之前的所有的和
        }
        int min = n+1;
        Deque<Integer> dq = new ArrayDeque<Integer>();    //dq存的是需要查询的起始位置
        for (int j=0;j<n+1;j++) {     //以i为结尾，以dq.pollFirst()为开始
            while (!dq.isEmpty() && preadd[j]-preadd[dq.peekFirst()]>=k) {
                int i = dq.pollFirst();
                min = Math.min(min,j-i);
            }
            while (!dq.isEmpty() && preadd[dq.peekLast()]>=preadd[j]) {
                dq.pollLast();
            }
            dq.addLast(j);
        }
        return min==n+1 ? -1 : min;
    }
}