class Solution {
    public int getKthMagicNumber(int k) {
        List<Integer> list = new ArrayList<Integer>();
        int x=1,y=2,z=3;
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        int num = 4;
        while (num<k) {
            int a = list.get(x)*3, b = list.get(y)*5, c = list.get(z)*7;
            int min = Math.min(a,Math.min(b,c));
            list.add(min);
            if (min == a) {
                x++;
            }
            if (min == b) {
                y++;
            }
            if (min == c) {
                z++;
            }
            // if (list.get(1)*list.get(x) <= list.get(2)*list.get(y) && list.get(1)*list.get(x) <= list.get(3)*list.get(z)) {
            //     if (list.get(1)*list.get(x) == list.get(2)*list.get(y)) {
            //         y++;
            //     }
            //     if (list.get(1)*list.get(x) == list.get(3)*list.get(z)) {
            //         z++;
            //     }
            //     list.add(list.get(1)*list.get(x));
            //     x++;

            // }
            // else if (list.get(2)*list.get(y) <= list.get(1)*list.get(x) && list.get(2)*list.get(y) <= list.get(3)*list.get(z)) {
            //     if (list.get(2)*list.get(y) == list.get(1)*list.get(x)) {
            //         x++;
            //     }
            //     if (list.get(2)*list.get(y) == list.get(3)*list.get(z)) {
            //         z++;
            //     }
            //     list.add(list.get(2)*list.get(y));
            //     y++;
            // }
            // else if (list.get(3)*list.get(z) <= list.get(1)*list.get(x) && list.get(3)*list.get(z) <= list.get(2)*list.get(y)) {
            //     if (list.get(3)*list.get(z) == list.get(1)*list.get(x)) {
            //         x++;
            //     }
            //     if (list.get(3)*list.get(z) == list.get(2)*list.get(y)) {
            //         y++;
            //     }
            //     list.add(list.get(3)*list.get(z));
            //     z++;
            // }
            num++;
        }

        // System.out.println(list);

        return list.get(k-1);
    }
}