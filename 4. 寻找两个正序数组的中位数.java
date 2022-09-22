/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] num = new int[l1+l2];
        boolean isEven = true;
        double average = 0.0;
        if ((l1+l2)%2!=0) {    //奇数
            isEven = false;
        }

        int i=0,j=0,t=0;
        while (i<l1 && j<l2) {
            if (nums1[i] <= nums2[j]) {
                num[t] = nums1[i];
                i++;
                t++;
            }
            else {
                num[t] = nums2[j];
                j++;
                t++;
            }
        }
        while (i<l1) {      //num1还有空余
            num[t] = nums1[i];
            i++;
            t++;
        }
        while (j<l2) {      //num2还有空余
            num[t] = nums2[j];
            j++;
            t++;
        }

        if (isEven==true) {     //偶数
            average = (num[(l1+l2)/2-1] + num[(l1+l2)/2]) * 1.0 / 2;

        }
        else {    //奇数
            average = num[(l1+l2)/2] * 1.0;
        }
        return average;
    }
}

// @lc code=end

