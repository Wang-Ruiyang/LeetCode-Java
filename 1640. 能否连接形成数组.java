class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int len = arr.length;
        boolean[] isTrue = new boolean[len];
        for (int i=0;i<len;i++) {
            isTrue[i] = false;
        }
        for (int i=0;i<pieces.length;i++) {    //遍历pieces
            for (int j=0;j<len;j++) {     //遍历arrs和isTrue
                if (pieces[i][0]==arr[j]) {
                    if (isTrue[j]==false) {
                        isTrue[j] = true;
                        if (pieces[i].length>1) {
                            int t = 1;
                            while (t<pieces[i].length && j<len-1) {
                                j++;
                                if (pieces[i][t] == arr[j] && isTrue[j]==false) {
                                    isTrue[j]= true;
                                    t++;
                                }
                                else {
                                    return false;
                                }
                            }
                        }
                        //当前pieces已经检索完毕，break进外面的for循环进行下一步
                        break;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        for (int i=0;i<len;i++) {
            if (isTrue[i]==false) {
                return false;
            }
        }
        return true;
    }
}