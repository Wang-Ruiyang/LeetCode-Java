class Solution {
    public int scoreOfParentheses(String s) {
        Deque<String> dq = new LinkedList<>();
        int n = s.length();
        for (int i=0;i<n;i++) {
            String st = String.valueOf(s.charAt(i));
            if (st.equals("(")) {
                dq.addLast(st);
            }
            if (st.equals(")")) {
                String temp = dq.pollLast();
                int sum = 0;
                while (!temp.equals("(")) {
                    sum += Integer.parseInt(temp);
                    temp = dq.pollLast();
                }
                if (temp.equals("(")) {
                    if (sum == 0) {
                        sum = 1;
                    }
                    else {
                        sum = sum * 2;
                    }
                    dq.addLast(Integer.toString(sum));
                }
            }
        }
        int sum = 0;
        while (!dq.isEmpty()) {
            String temp = dq.pollLast();
            sum += Integer.parseInt(temp);
        }
        return sum;

    }
}