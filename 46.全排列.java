import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        if (n==0 || n==1) {
            return res;
        }
        int i = n-2;
        while (i>-1) {
            i = n-2;
            while (i>=0) {
                if (nums[i]<nums[i+1]) {   //从后向前第一个升序组合
                    Arrays.sort(nums,i+1,n);
                    int j = i+1;
                    while (j<n) {
                        if (nums[j]>nums[i]) {
                            int temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                            break;
                        }
                        j++;
                    }
                    res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                    break;
                }
                else {
                    i--;
                }
            }
        }
        return res;

    }
}