class Solution {

    public boolean isOK(String s1,String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int i=0,j=0;
        boolean isFind = false;
        while (i<n1 && j<n2) {
            if (s1.charAt(i)==s2.charAt(j)) {
                i++;
                j++;
            }
            else {
                if (!isFind) {
                    isFind = true;
                    if (n1==n2) {
                        i++;
                        j++;
                    }
                    else {    //n1一定大于n2
                        i++;
                    }
                }
                else {
                    return false;
                }

            }
        }
        if ((i==n1 && j==n2) || (i==j && j==n2 && !isFind)) {
            return true;
        }
        return false;
    }

    public boolean oneEditAway(String first, String second) {
        int n1 = first.length();
        int n2 = second.length();
        if (n1-n2!=1 && n1-n2!=0 && n1-n2!=-1) {
            return false;
        }
        if (first.equals(second)) {
            return true;
        }
        //短的增加1个 等价于 长的减少1个
        if(n1>=n2) {
            return isOK(first,second);
        }
        else {
            return isOK(second,first);
        }

    }
}