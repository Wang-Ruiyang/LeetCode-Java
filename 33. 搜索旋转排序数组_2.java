class Solution {
    public int search(int[] nums, int target) {
        //时间复杂度为logn的搜索：二分查找
        int n = nums.length;
        int k = 0;
        for (int i=0;i<n-1;i++) {
            if (nums[i]>nums[i+1]) {
                k = n-(i+1);
                break;
            }
        }
        // System.out.println(k);
        //k表示向左移动的次数
        int i = 0,j = n-1;
        while (i<=j) {
            int t = (i + j)/2;
            if (nums[(t-k+n)%n] > target) {
                j = t-1;
            }
            else if (nums[(t-k+n)%n] < target) {
                i = t+1;
            }
            else {
                return (t-k+n)%n;
            }
        }
        return -1;
    }
}