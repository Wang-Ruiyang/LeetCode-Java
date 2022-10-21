class StockSpanner {

    Deque<Stock> st;

    class Stock {
        public int price;
        public int day;
        public Stock(int price, int day) {
            this.price = price;
            this.day = day;
        }
    }

    public StockSpanner() {
        st = new ArrayDeque<Stock>();
    }

    public int next(int price) {
        int day = 1;
        if (!st.isEmpty()){
            while (!st.isEmpty()) {
                Stock temp = st.peekLast();
                if (price>=temp.price) {
                    st.pollLast();
                    day = day + temp.day;
                }
                else {
                    break;
                }
            }
        }
        st.addLast(new Stock(price,day));
        return day;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */