/*
 * @lc app=leetcode.cn id=811 lang=java
 *
 * [811] 子域名访问计数
 */

// @lc code=start
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> hash = new HashMap<String,Integer>();
        int n = cpdomains.length;     //length是数组的方法
        List<String> res = new ArrayList<String>();
        for (int i=0;i<n;i++) {
            String[] sa = cpdomains[i].split(" ");     //按照空格进行分割
            int times = Integer.parseInt(sa[0]);
            
            for (int j=0;j<sa[1].length();j++) {   //length()是字符串的方法
                if (j==0 || sa[1].charAt(j-1)=='.') {
                    if (hash.containsKey(sa[1].substring(j))) {
                        hash.replace(sa[1].substring(j), hash.get(sa[1].substring(j))+times);
                    }
                    else {
                        hash.put(sa[1].substring(j), times);
                    }
                }
            }
        }
        if (!hash.isEmpty()) {
            hash.forEach((key,value) -> {
                String s = value.toString() + " " + key;
                res.add(s);
            });
        }

        return res;
    }
}
// @lc code=end

