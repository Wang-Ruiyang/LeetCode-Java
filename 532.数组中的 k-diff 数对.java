class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0, j = 1;
        int sum = 0;
        for (i=0;i<n-1;i++) {
            if (i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            int t = nums[i]+k;
            j = Math.max(i+1,j);    //很关键，有可能i在上面那个if后比j跑的还远
            while (j<n) {
                if (nums[j] < t) {
                    j++;
                }
                else if (nums[j] == t) {
                    sum++;
                    j++;
                    break;
                }
                else {
                    break;
                }
            }
        }
        return sum;
    }
}