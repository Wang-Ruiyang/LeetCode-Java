class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> dq = new LinkedList<>();
        for (int i=0;i<students.length;i++) {
            dq.addLast(students[i]);
        }
        int i = 0;
        int temp = 0;    //记录出现死循环（如果不论学生怎么转都不能匹配）
        while (!dq.isEmpty()) {
            int k = dq.pollFirst();
            if (i>=sandwiches.length) {
                break;
            }
            if (k==sandwiches[i]) {
                i++;
                temp = 0;      //匹配成功则将temp置为0
            }
            else {
                dq.addLast(k);
                temp++;      //不成功就+1
                if (temp==dq.size()) {
                    break;
                }
            }
        }
        return dq.size();
    }
}