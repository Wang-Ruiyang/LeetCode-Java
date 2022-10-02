class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int i = 0, j = n-1;

        if (n==1) {
            if (nums[0] == target) {
                return new int[]{0,0};
            }
            else {
                return new int[]{-1,-1};
            }

        }
        int[] result = {-1,-1};
        while(i<=j) {
            int t = (i+j)/2;
            if (nums[t] > target) {
                j = t - 1;
            }
            else if (nums[t] <target) {
                i = t + 1;
            }
            else {
                i = t;
                j = t;
                result[0] = i;
                result[1] = j;
                while (nums[i] == target && i>0) {
                    if (nums[i-1] == target) {
                        i--;
                        result[0] = i;
                    }
                    else {
                        break;
                    }
                }
                while (nums[j] == target && j<n-1) {
                    if (nums[j+1] == target) {
                        j++;
                        result[1] = j;
                    }
                    else {
                        break;
                    }
                }
                break;
            }
        }
        return result;
    }
}