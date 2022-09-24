/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int i=0,j=1;
        while (i<len && j<len) {
            if (nums[i] == nums[j]) {
                j++;
            }
            else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i+1;
    }
}
// @lc code=end

