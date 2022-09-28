import java.util.Arrays;

class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        char[] sa1 = s1.toCharArray();
        char[] sa2 = s2.toCharArray();

        Arrays.sort(sa1);
        Arrays.sort(sa2);

        return String.valueOf(sa1).equals(String.valueOf(sa2));

    }
}