class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i=len-1;i>0;i--) {
            if (nums[i] > nums[i-1]) {    //找从后往前的第一个相邻的升序组合
                Arrays.sort(nums,i,len);     //表示对nums数组进行下标为i到len-1的位置进行排序（从小到大）
                for (int j=i;j<len;j++) {
                    if (nums[j]>nums[i-1]) {
                        int temp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = temp;
                        return ;
                    }
                }
            }
        }
        // 如果从头到尾都是越来越小
        Arrays.sort(nums);
        return ;
    }
}