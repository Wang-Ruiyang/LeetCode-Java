class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] nums = new int[2];    //记录学生的0和1的数量
        for (int i=0;i<students.length;i++) {
            nums[students[i]]++;
        }

        for (int i=0;i<sandwiches.length;i++) {
            nums[sandwiches[i]]--;
            if (nums[sandwiches[i]]==-1) {    //表示本来就只有0个学生要这种披萨，但是目前披萨的第一个就是这种，所以在这里会卡住
                return sandwiches.length - i;    //包含当前i
            }
        }

        //披萨和学生数量相同，所以不会出现披萨没了学生还有的情况。
        //所以除了会因为卡在第一个披萨的情况而结束，就只可能是成功的状态而结束。
        return 0;
    }
}