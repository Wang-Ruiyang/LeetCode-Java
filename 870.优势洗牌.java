class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] index = new Integer[n];
        for (int i=0;i<n;i++) {
            index[i] = i;
        }
        Arrays.sort(nums1);
        Arrays.sort(index,(a,b)->nums2[a]-nums2[b]);    //对于index的值a和b，如果nums2[a]更大，则a放在后面
        //此时nums1已经是从小到大，index的值对应的nums2也是从小到大
        int i = 0, j = n-1;
        for (int num : nums1) {
            if (num > nums2[index[i]]) {
                nums2[index[i]] = num;
                i++;
            }
            else {
                nums2[index[j]] = num;
                j--;
            }
        }
        return nums2;
    }
}