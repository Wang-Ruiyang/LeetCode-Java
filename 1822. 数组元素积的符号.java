class Solution {
    public int arraySign(int[] nums) {
        int f = 0;
        for (int num : nums) {
            if (num<0) {
                f++;
            }
            else if (num==0) {
                return 0;
            }
        }
        return f%2==0 ? 1 : -1;
    }
}