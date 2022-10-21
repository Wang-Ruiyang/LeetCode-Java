class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int res = 0;
        int maxi = values[0];    //最大的values[i]+i
        //找最大的values[j]-j
        for  (int j=1;j<values.length;j++) {
            //以当前节点为j，将它和前面的最大的i对应的值相加，和原有的res比较
            res = Math.max(res, maxi+values[j]-j);
            //判断如果当前节点不是j而是i，和原本的maxi进行比较更新maxi
            maxi = Math.max(maxi, values[j]+j);
        }
        return res;
    }
}