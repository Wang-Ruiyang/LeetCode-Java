class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        List<Integer> z = new ArrayList<>();
        z.add(-1);
        List<Integer> f = new ArrayList<>();
        int len = 0;
        for (int i=0;i<n;i++) {
            if (nums[i]==0) {
                z.add(i);
                f.add(len);
                len = 0;
            }
            if (nums[i]<0) {
                len++;
            }
        }
        z.add(n);
        f.add(len);
        int max = 0;
        for (int i=0;i<z.size()-1;i++) {
            int left = z.get(i)+1;
            int right = z.get(i+1);
            if (f.get(i)%2==0) {
                max = Math.max(max,right-left);
            }
            else {
                int j=left,t=right-1;
                while (j<=t) {
                    if (j==t) {     //一定是负数
                        max = Math.max(max,j-left);
                        break;
                    }
                    if (nums[j]<0) {
                        max = Math.max(max,right-j-1);
                        break;
                    }
                    if (nums[t]<0) {
                        max = Math.max(max,t-left);
                        break;
                    }
                    j++;
                    t--;
                }
            }
        }
        return max;
    }
}