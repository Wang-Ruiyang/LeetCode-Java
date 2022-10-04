import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
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
            if (target-candidates[i]<0) {
                break;
            }
            path.addLast(candidates[i]);     //双端队列在结尾增加
            DFS(candidates,i,len,target-candidates[i],path,res);
            path.removeLast();    //双端队列删去刚刚在上一个DFS中加入的值，继续进入循环，判断下一个分支
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len==0) {
            return res;
        }

        Arrays.sort(candidates);    //排序

        Deque<Integer> path = new LinkedList<>();   //构造一个双端队列

        DFS(candidates,0,len,target,path,res);

        return res;
    }
}
// @lc code=end

