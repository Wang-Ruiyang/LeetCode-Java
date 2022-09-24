import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);     //排序
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i=0;i<len && nums[i]<=0;i++) {   //定死最小的那个值的位置为i，且值一定<=0
            if (i>0) {
                if (nums[i]==nums[i-1]) {
                    continue;
                }
            }
            int sum = nums[i]*(-1);
            int j = i+1;
            int t = len-1;
            while (j<len && j<t) {
                if (nums[j] + nums[t] < sum) {
                    j++;
                }
                else if (nums[j] + nums[t] == sum) {
                    boolean isSame = false;
    
                    if (result.size()!=0) {      //判断有没有重复
                        if (nums[i] == result.get(result.size()-1).get(0) && nums[j]==result.get(result.size()-1).get(1) && nums[t]==result.get(result.size()-1).get(2)) {
                            isSame = true;
                        }
                    }
                    
                    if (!isSame) {
                        List<Integer> r = new ArrayList<Integer>();
                        r.add(Integer.valueOf(nums[i]));
                        r.add(Integer.valueOf(nums[j]));
                        r.add(Integer.valueOf(nums[t]));
                        result.add(r);
                    }
                    t--;
                    j++;
                }
                else {
                    t--;
                }
            }
        }
        return result;
    }
}
// @lc code=end

