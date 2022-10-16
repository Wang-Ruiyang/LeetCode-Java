class Solution {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> al = new ArrayList<String>();
        int t = 1;
        for (int i=0;i<target.length;i++) {
            while (t<=target[i]) {
                al.add("Push");
                if (t<target[i]) {
                    al.add("Pop");
                }
                t++;

            }
        }
        return al;
    }
}