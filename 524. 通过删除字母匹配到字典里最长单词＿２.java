class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        // Collections.sort(dictionary,new Comparator<String>() {
        //     public int compare(String s1, String s2) {
        //         if (s1.length() == s2.length()) {
        //             if (s1.compareTo(s2)>0) {
        //                 return 1;
        //             }
        //             else {
        //                 return -1;
        //             }
        //         }
        //         return s1.length()-s2.length();
        //     }
        // });

        String res = "";
        int reslength = 0;
        for (String st : dictionary) {
            if (st.length() < reslength) {
                continue;
            }
            if (st.length() == reslength && st.compareTo(res)>0) {
                continue;
            }
            int i=0,j=0;
            while (i<s.length() && j<st.length()) {
                if (s.charAt(i) == st.charAt(j)) {
                    i++;
                    j++;
                }
                else {
                    i++;
                }
            }
            if (j==st.length()) {
                res = st;
                reslength = j;
            }
        }

        return res;

    }
}