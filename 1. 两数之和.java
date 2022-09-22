class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] temp = new int[len];
        for (int i=0;i<len;i++){
            temp[i] = nums[i];
        }
        Arrays.sort(temp);

        int i = 0;
        int j = len-1;
        int[] result = new int[2];
        while(i<j) {
            if (temp[i]+temp[j]==target) {
                break;
            }
            else if (temp[i]+temp[j]>target){
                j--;
            }
            else {
                i++;
            }
        }

        for (int t = 0,l=0;t<len;t++){
            if (nums[t]==temp[i] || nums[t]==temp[j]) {
                result[l] = t;
                l++;
                if(l==2) {
                    break;
                }
            }
        }

        return result;
    }
}