/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static boolean isLeaf(TreeNode root) {
        if (root.left==null && root.right==null) {
            return true;
        }
        return false;
    }

    public static int FindMin(TreeNode root,int temp) {
        if (isLeaf(root)) {
            return root.val;
        }
        int a = FindMin(root.left,temp);
        int b = FindMin(root.right,temp);
        if (a == temp && b == temp) {
            return temp;
        }
        else if (a == temp) {
            return b;
        }
        else if (b == temp) {
            return a;
        }
        else {
            return Math.min(a,b);
        }
    }

    public int findSecondMinimumValue(TreeNode root) {
        // 每个节点都是以这个节点为根的树的最小值
        int min = root.val;
        if (root.left==null && root.right==null) {
            return -1;
        }
        int a = FindMin(root.left,min);
        int b = FindMin(root.right,min);


        if (a == min && b == min) {
            return -1;
        }
        if (a==min) {
            return b;
        }
        if (b==min) {
            return a;
        }
        if (a!=min && b!=min) {
            return Math.min(a,b);
        }


        return Math.min(a,b);

    }
}