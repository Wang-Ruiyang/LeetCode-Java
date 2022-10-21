class StockSpanner {

    int index;
    int[] prices;
    int[] days;

    public StockSpanner() {
        index = 0;
        prices = new int[100010];
        days = new int[100010];
    }

    public int next(int price) {
        int p = index-1;
        while (p>=0 && price>=prices[p]) {
            p = p - days[p];
        }
        prices[index] = price;
        days[index] = index - p;
        index ++;
        return days[index-1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */