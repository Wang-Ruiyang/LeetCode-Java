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
    int res;  //记录第二小值
    int v;    //记录最小值

    public void dfs(TreeNode root) {
        if (root==null) {
            return;
        }
        if (root.val != v) {
            if (res == -1) {   //如果res还没有更新过
                res = root.val;
            }
            else {
                res = Math.min(res,root.val);
            }
        }
        dfs(root.left);
        dfs(root.right);
    }

    public int findSecondMinimumValue(TreeNode root) {
        res = -1;
        v = root.val;
        dfs(root);
        return res;
    }
}