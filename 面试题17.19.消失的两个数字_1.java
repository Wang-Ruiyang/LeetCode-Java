import java.util.Arrays;

class Solution {
    public int[] missingTwo(int[] nums) {
        int[] result = new int[2];    //输出结果的数组
        Arrays.sort(nums);
        int j = 0, k = 1;      //j是定位result数组的，k是当前nums应该是的值
        int len = nums.length;     //nums数组的长度
        for (int i=0;i<len;i++) {
            if (nums[i]>k) {
                result[j] = k;
                j++;
                i--;
                k++;
            }
            else {
                k++;
            }
            if (j==2) {
                return result;
            }
        }
        while (j<=1) {
            result[j] = k;
            j++;
            k++;
        }
        return result;
    }
}