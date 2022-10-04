/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {

    public static void DFS(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        else if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=begin;i<len;i++) {
            //第一次剪枝
            if (target - candidates[i] < 0) {
                break;
            }
            //第二次剪枝
            if (i>begin && candidates[i]==candidates[i-1]) {
                continue;
            }
            path.addLast(candidates[i]);
            if (i+1 > len) {
                break;
            }
            DFS(candidates, i+1, len, target-candidates[i], path, res);
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len==0) {
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new LinkedList<>();

        DFS(candidates, 0, len, target, path, res);

        return res;
    }
}
// @lc code=end

