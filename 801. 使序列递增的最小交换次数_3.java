class Solution {
    public int minSwap(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int nc = 0;
        int c = 1;
        for (int i=1;i<n;i++) {
            // 第三种
            if ((nums1[i]>nums1[i-1] && nums2[i]>nums2[i-1]) && (nums1[i]>nums2[i-1] && nums2[i]>nums1[i-1])) {
                nc = Math.min(nc,c);
                c = nc + 1;
            }
            // 第一种
            else if (nums1[i]>nums1[i-1] && nums2[i]>nums2[i-1]) {
                c = c + 1;
            }
            // 第二种
            else {
                int temp = nc;
                nc = c;
                c = temp + 1;
            }
        }
        return Math.min(nc,c);

    }
}