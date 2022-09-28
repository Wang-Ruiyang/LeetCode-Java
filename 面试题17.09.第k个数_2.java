import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public int getKthMagicNumber(int k) {
        int[] nums = new int[] {3,5,7};
        PriorityQueue<Long> q = new PriorityQueue<>();     // 构建小根堆
        Set<Long> set = new HashSet<>();
        q.add(1L);    //存储的是1，但是是以L（long）形式存储
        set.add(1L);

        while (!q.isEmpty()) {     //对于堆，每次读取都会抽出，导致数量在减少
            //先弹出最小的，用t记录
            long t = q.poll();    //小根堆弹出第一个（最小的那个）
            k--;
            if (k==0) {
                return (int)t;
            }
            //再进行运算，并判断有没有相同的
            for (int num : nums) {
                if (!set.contains(num*t)) {   //如果num*t再set中不存在
                    q.add(num*t);
                    set.add(num*t);
                }
            }
            //相当于每次弹出一个，增加3个
        }
        return -1;
    }
}